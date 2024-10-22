package com.procurement.requisition.create;

import com.interfaces.procurementInterfaces.Login.LoginPageInterface;
import com.interfaces.procurementInterfaces.Logout.LogoutPageInterface;
import com.microsoft.playwright.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class catalogPrCreate extends prCreateAbstract{

    public catalogPrCreate(LoginPageInterface loginPageInterface, Properties properties, Page page, LogoutPageInterface logoutPageInterface) {
        super(loginPageInterface, properties, page, logoutPageInterface);
    }

    public void CatalogCreate() throws InterruptedException {
        RequesterLoginPRCreate();
        CreateButton();
        PrType();
        Title();
        Project();
        WBS();
        VendorSelection();
        RateContract();
        ShippingAddress();
        ShippingMode();
        ExpectedPOIssue();
        ExpectedDelivery();
        ProjectManager();
        BuyerManager();
        InspectionRequired();
        OrderIntake();
        Tcas();
        TcasCheck();
        TcasFileUpload();
        ImportItems();
        AddLineRequisitionItems();
        Notes();
        NotesAttachments();
        PRCreate();
    }

    @Override
    public void PrType() {
        page.locator("//tbody/tr[1]/td[1]/a[1]").click();
    }

    @Override
    public void VendorSelection(){
        page.locator("//span[contains(@id,'vendorId')]").click();

        page.locator("//input[@class='select2-search__field']").fill(properties.getProperty("Vendor"));
        Response response = page.waitForResponse(
                resp -> resp.url().startsWith("https://dprocure-test.cormsquare.com/api/RateContractsByVendorIdandCompany?vendorId=") && resp.status() == 200,
                () -> {
                    page.locator("//li[contains(text(),'" + properties.getProperty("Vendor") + "')]").click();
                }
        );
    }

    @Override
    public void RateContract(){
        page.locator("//span[@id='select2-rateContractId-container']").click();
        page.locator("//input[@class='select2-search__field']").fill(properties.getProperty("RateContract"));
        page.locator("//li[contains(text(),'" + properties.getProperty("RateContract") + "')]").click();
    }

    @Override
    public void ImportItems(){
        page.locator("#importItem").click();
        Locator CommercialFile = page.locator("#formFile");
        CommercialFile.setInputFiles(Paths.get("Attachments-and-import-files/RateContractItems.xlsx"));
        page.locator("#btnUpload").click();
    }

    public void CreateItemsFile() throws InterruptedException {
        page.locator("#itemImport").click();

        // Wait for the new tab (or page) to be created
        Page newTab = page.waitForPopup(() -> {
            page.click("#btntoCatalogExport");  // Clicking on a link that opens a new tab
        });
        page.click("//button[(@aria-label='Close') and (contains(text(),'Cancel'))]");

        // Now you can interact with the new tab
        newTab.waitForLoadState();
        newTab.locator(".form-control-sm").fill(properties.getProperty("RateContract"));
        Download download = newTab.waitForDownload(() -> {
            newTab.click("//a[(@class='export-link') and (contains(text(),'"+properties.getProperty("RateContract")+"'))]");
        });
        // Wait for the download to complete and save it to a specific location
        download.saveAs(Paths.get("Attachments-and-import-files/" + download.suggestedFilename()));
        newTab.close();

        String filePath = "Attachments-and-import-files/ExportItems.xlsx"; // Path to your Excel file

        try {
            // Step 1: Load the Excel file
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet (index 0)


            // Step 2: Delete the second row (row index 1)
            if(sheet.getLastRowNum()>2){
                Row rowToDelete = sheet.getRow(1); // Get the second row (index 1)

                if (rowToDelete != null) {
                    sheet.removeRow(rowToDelete);  // Delete the row

                    // Step 3: Shift the rows up (if necessary) to fill the gap left by the deleted row
                    if (1 < sheet.getLastRowNum()) {
                        sheet.shiftRows(2, sheet.getLastRowNum(), -1);  // Shift rows starting from the third row up
                    }
                }
            }

            // Step 2: Start the loop from the second row (index 1)
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) { // rowIndex 1 for second row
                Row row = sheet.getRow(rowIndex);

                if (row != null) { // Check if the row exists
                    Cell cell = row.getCell(9); // Get column F (index 5)

                    // Check if the cell is null and create one if needed
                    if (cell == null) {
                        cell = row.createCell(9); // Create the cell in column F if it doesn't exist
                    }

                    // Step 3: Set a value in column F (you can set the value based on your logic)
                    cell.setCellValue(rowIndex*2+1);  // You can put any string or number here
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
//        CommercialFile.setInputFiles(Paths.get("Attachments-and-import-files/ExportItems.xlsx"));
        CommercialFile.setInputFiles(Paths.get("./Attachments-and-import-files/ExportItems.xlsx"));

        page.locator("#btnUpload").click();

        Thread.sleep(100000);
    }
}
