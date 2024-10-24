package com.procurement.requestforquotations.quotationsubmit;

import com.interfaces.procurementInterfaces.Login.LoginPageInterface;
import com.interfaces.procurementInterfaces.Logout.LogoutPageInterface;
import com.interfaces.procurementInterfaces.RequestForQuotations.QuotationSubmit;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class RegisteredVendorQuotationSubmit implements QuotationSubmit {

    Properties properties;
    Page page;
    LoginPageInterface loginPageInterface;
    LogoutPageInterface logoutPageInterface;

    private RegisteredVendorQuotationSubmit(){
    }

//TODO Constructor
    public RegisteredVendorQuotationSubmit(LoginPageInterface loginPageInterface, Properties properties, Page page, LogoutPageInterface logoutPageInterface){
        this.loginPageInterface = loginPageInterface;
        this.properties = properties;
        this.page = page;
        this.logoutPageInterface = logoutPageInterface;
    }

    public void InviteRegisteredVendor(){
        loginPageInterface.LoginMethod(properties.getProperty("Buyer"));
        page.locator("//*[contains(text(), 'Request For Quotations')]").click();
        String title = properties.getProperty("Title");
        page.locator("//span[contains(text(), '"+ title +"')]").first().click();
        page.locator("#addRequestForQuotationVendors").click();
        page.locator("#select2-vendorId-container").click();
        String vendor = properties.getProperty("Vendor");
        page.locator(".select2-search__field").fill(vendor);
        page.locator("//li[contains(text(), 'VEN-00084 - Alpha Limited')]").first().click();
        page.locator("#saveRequestForQuotationVendor").click();
        page.locator("#vendorSendMailBtnId").click();
        logoutPageInterface.LogoutMethod();
    }


    public void QuotationSubmit() throws InterruptedException {
        VendorLogin();
        Compliances();
        QuotationItems();
        QuotationAttachments();
        QuotationSubmitButton();
    }
    public void VendorLogin() throws InterruptedException {
        loginPageInterface.LoginMethod(properties.getProperty("VendorMailId"));
        String title = properties.getProperty("Title");
        page.locator("//span[contains(text(), '" + title + "')]").first().click();
        page.locator("#btnSendQuote").click();
        page.locator("#incotermLocation").fill(properties.getProperty("Incoterm"));
        page.locator("#quotationReferenceNumber").fill(properties.getProperty("QuotationReferenceNumber"));
        Thread.sleep(2000);
        Locator validityDate = page.locator("#dates");
        validityDate.click();
        Locator today = page.locator("(//span[@class='flatpickr-day today'])[2]");
        if (Integer.parseInt(today.textContent()) < 20){
            page.locator("//span[text()='28' and not(contains(@class,'prevMonthDay'))]").click();
        }
        else{
            page.locator("(//span[@class='flatpickr-next-month'])[2]").click();
                page.locator("(//span[text()='5' and not(contains(@class,'prevMonthDay')) and not(contains(@class,'nextMonthDay'))])[2]").click();
        }
    }

    public void Compliances(){
        page.locator("#liquidatedComplyId").click();
        page.locator("#rohsComplyId").click();
        page.locator("#warrantyRequirementsComplyId").click();
//        page.locator("#packingForwardingComplyId").click();
//        page.locator("#freightComplyId").click();
//        page.locator("#insuranceComplyId").click();
//        page.locator("#bankGuaranteeComplyId").click();
    }

    public void QuotationItems() {
        Download download = page.waitForDownload(() -> {
            page.click("#exportItem");
        });
        download.saveAs(Paths.get("Attachments-and-import-files/" + download.suggestedFilename()));
        String filePath = "Attachments-and-import-files/ExportItems.xlsx"; // Path to your Excel file
        try {
            // Step 1: Load the Excel file
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet (index 0)

            // Step 2: Start the loop from the second row (index 1)
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) { // rowIndex 1 for second row
                Row row = sheet.getRow(rowIndex);

                if (row != null) { // Check if the row exists
                    row.getCell(6).setCellValue("Notes " + rowIndex);
                    row.getCell(7).setCellValue("123456");
                    row.getCell(8).setCellValue("Make "+rowIndex);
                    row.getCell(9).setCellValue("Model "+rowIndex);
                    row.getCell(10).setCellValue("PartNo. "+rowIndex);
                    row.getCell(11).setCellValue("ReqPart. "+rowIndex);
                    row.getCell(12).setCellValue("ReqManu. "+rowIndex);
                    row.getCell(13).setCellValue("Uganda");
                    row.getCell(16).setCellValue(25.27);
                    row.getCell(17).setCellValue(5);
                }
            }

            // Step 4: Write the updated data back to the file
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            // Step 5: Close the streams
            fileInputStream.close();
            fileOutputStream.close();
            workbook.close();
            System.out.println("Excel file updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        page.locator("#importItem").click();
        Locator CommercialFile = page.locator("#formFile");
        CommercialFile.setInputFiles(Paths.get("./Attachments-and-import-files/ExportItems.xlsx"));
        page.locator("#btnUpload").click();

        //GST %
        page.locator("#gstId").fill(properties.getProperty("GST"));


//        //Specifications
//        List<Locator> ViewSpecification = page.locator("#viewitemspecification").all();
//        for(Locator x : ViewSpecification){
//            x.click();
//            page.locator("#complyAll").click();
//            page.locator("#itemSpecificationSave").click();
//        }
    }
    public void QuotationAttachments() {
//TODO Technical Attachment
        page.locator("#attachFile").click();
        Locator TechnicalFile = page.locator("#formFilePreupload");
        TechnicalFile.setInputFiles(Paths.get("Attachments-and-import-files/Technical Attachment.xlsx"));
        page.locator("#select2-attachmentTypeId-container").click();
        page.locator("//li[contains(text(), 'Technical')]").click();
        page.locator("#attachmentSaveId").click();
//TODO Commercial Attachment
        page.locator("#attachFile").click();
        Locator CommercialFile = page.locator("#formFilePreupload");
        CommercialFile.setInputFiles(Paths.get("Attachments-and-import-files/Commercial Attachment.xlsx"));
        page.locator("#select2-attachmentTypeId-container").click();
        page.locator("//li[contains(text(), 'Commercial')]").click();
        page.locator("#attachmentSaveId").click();
    }

    public void QuotationSubmitButton(){
        page.locator("#btnCreate").click();
        page.locator(".bootbox-accept").click();
        logoutPageInterface.LogoutMethod();
    }
}