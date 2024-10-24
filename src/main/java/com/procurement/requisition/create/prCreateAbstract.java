package com.procurement.requisition.create;

import com.interfaces.procurementInterfaces.Login.LoginPageInterface;
import com.interfaces.procurementInterfaces.Logout.LogoutPageInterface;
import com.interfaces.procurementInterfaces.Requisition.PrCreate;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.procurement.loc.requisition.requisitionLocators;

import java.nio.file.Paths;
import java.util.Properties;

public abstract class prCreateAbstract implements PrCreate {
    Page page;
    LoginPageInterface loginPageInterface;
    LogoutPageInterface logoutPageInterface;
    Properties properties;



    //TODO Constructor
    public prCreateAbstract(LoginPageInterface loginPageInterface, Properties properties, Page page, LogoutPageInterface logoutPageInterface){
        this.page = page;
        this.properties = properties;
        this.loginPageInterface = loginPageInterface;
        this.logoutPageInterface = logoutPageInterface;
    }

    public void RequesterLoginPRCreate() throws InterruptedException {
        loginPageInterface.LoginMethod(properties.getProperty("EmailID"));
        page.waitForLoadState(LoadState.NETWORKIDLE);
//        page.locator("//a[contains(@class,'nav-link') and contains(@href,'Requisitions')]").click();
//        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void CreateButton() {
        page.locator("//button[@data-bs-target='#createPRModal']").click();
    }

    public abstract void PrType();


    public void Title() {
        page.locator("//input[@id='title']").fill(properties.getProperty("Title"));
    }

    public void ShipToYokogawa() {
        page.locator("//input[@id='shipToYokogawa']").check();
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void Project() throws InterruptedException {
        Locator project = page.locator("#select2-projectId-container");
        project.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        project.click();

        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("Project"));
        String getProject = requisitionLocators.projectMethod(properties);
        Locator getProject1 = page.locator(getProject);
        getProject1.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        getProject1.click();
//        page.waitForLoadState(LoadState.NETWORKIDLE);
//        Response response = page.waitForResponse(
//                resp -> resp.url().startsWith("https://dprocure-test.cormsquare.com/api/StorageLocations") && resp.status() == 200,
//                () -> {
//                    page.locator(getProject).click();
//                }
//        );
    }

    public void WBS() {
        Locator wbs = page.locator("#select2-wbsId-container");
        wbs.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        wbs.click();
        Locator wbs1= page.locator(".select2-search__field");
        wbs1.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        wbs1.fill(properties.getProperty("Wbs"));
        Locator getWbs = page.locator("//li[contains(text(),'" + properties.getProperty("Wbs") + "')][1]");
        getWbs.waitFor(new Locator.WaitForOptions().setTimeout(5000).setState(WaitForSelectorState.VISIBLE));
        getWbs.click();
//        page.locator("#select2-wbsId-container").click();
//        page.locator(".select2-search__field").fill(properties.getProperty("Wbs"));
//        Locator getWbs = page.locator("//li[contains(text(),'" + properties.getProperty("Wbs") + "')][1]");
//        getWbs.waitFor();
//        getWbs.click();
    }

    public abstract void VendorSelection();

    public abstract void RateContract();

    public void Incoterm() {
        page.locator("#select2-incoterm-container").click();
        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("Incoterm"));
        Locator getIncoterm = page.locator("//li[contains(text(),'" + properties.getProperty("Incoterm") + "')]");
        getIncoterm.click();
    }

    public void LiquidatedDamages() {
        page.locator("//input[@id='isLDStandardNoId']").click();
        page.locator("//input[@id='liquidatedamageTextId']").fill(properties.getProperty("LiquidatedDamages"));
    }
    public void ShippingAddress() {
        page.locator("//span[@aria-labelledby='select2-shippingaddressId-container']").click();
        Locator ship = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions().setName(properties.getProperty("ShippingAddress")));
        if (ship.count() > 0)
            ship.click();
        else
            page.locator("//ul[@id='select2-shippingaddressId-results']/li").first().click();
    }
    public void StorageLocation() {
        page.locator("#select2-storageLocId-container").click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(properties.getProperty("StorageLocation"))).click();
    }

    public void ShippingMode() {
        page.getByText("-- Select Shipping Mode --").click();
        Locator getShippingMode = page.locator("//li[contains(text(),'" + properties.getProperty("ShippingMode") + "')]");
        if (getShippingMode.count()>0)
            getShippingMode.click();
        else
            page.locator("//ul[contains(@id,'select2-shipping')]/li").first().click();
    }

    public void QuotationRequiredBy() {
        Locator quotationRequiredBy = page.locator("//div[@id='dates']//input[@name='quotationRequiredBy']/following::input[1]");
        quotationRequiredBy.click();
        Locator today = page.locator("//span[@class='flatpickr-day today']").first();
        today.click();
    }

    public void ExpectedPOIssue() {
        Locator expectedPOIssue = page.locator("//div[@id='dates']//input[@name='expectedPoIssue']/following::input[1]");
        expectedPOIssue.click();
        Locator today = page.locator("//span[@class='flatpickr-day today']").first();
        today.click();
    }

    public void ExpectedDelivery() {
        Locator expectedDelivery = page.locator("//div[@id='dates']//input[@name='expectedDelivery']/following::input[1]");
        expectedDelivery.click();
        Locator today = page.locator("//span[@class='flatpickr-day today']").first();
        today.click();
    }

    public void BuyerGroup(){
        page.locator("#select2-buyergroupid-container").click();
        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("BuyerGroup"));
        Locator getBuyerGroup = page.locator("//li[contains(text(),'" + properties.getProperty("BuyerGroup") + "')]");
        getBuyerGroup.click();
    }
    public void RoHS(){
        page.locator("#rohsnotcomplianceid").check();
    }
    public void Checker(){
        page.locator("#select2-checkerId-container").click();
        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("Checker"));
        Locator getBuyerGroup = page.locator("//li[contains(text(),'" + properties.getProperty("Checker") + "')]");
        getBuyerGroup.click();
    }
    public void BuyerManager(){
        page.locator("#select2-buyerManagerId-container").click();
        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("BuyerManager"));
        Locator getBuyerManager = page.locator("//li[contains(text(),'" + properties.getProperty("BuyerManager") + "')]");
        getBuyerManager.click();
    }

    public void ProjectManager(){
        page.getByLabel("-- Select Project Manager --").click();
        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("ProjectManager"));
        Locator getProjectManager = page.locator("//li[contains(text(),'" + properties.getProperty("ProjectManager") + "')]");
        getProjectManager.click();
    }

    public void OrderIntake(){
        page.getByPlaceholder("Enter Order Intake Cost").click();
        page.getByPlaceholder("Enter Order Intake Cost").fill(String.valueOf(properties.getProperty("OrderIntake")));
    }

    public void TargetPrice(){
        page.getByPlaceholder("Enter Target Price").click();
        page.getByPlaceholder("Enter Target Price").fill(String.valueOf(properties.getProperty("TargetPrice")));
    }

    public void WarrantyRequirements(){
        page.getByLabel("-- Select Warranty Requirements --").click();
        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("WarrantyRequirement"));
        Locator getWarrantyRequirement = page.locator("//li[contains(text(),'" + properties.getProperty("WarrantyRequirement") + "')]");
        getWarrantyRequirement.click();
    }
    public void Tcas(){
        page.locator("#tcasApplicable").click();
    }
    public void TcasCheck(){
        page.locator("#q1").click();
        page.locator("#tcasSubmit").click();
    }
    public void TcasFileUpload(){
        Locator CommercialFile = page.locator("#tcasFilePreupload");
        CommercialFile.setInputFiles(Paths.get("Attachments-and-import-files/TCAS.xlsx"));
//        FileChooser fileChooser = page.waitForFileChooser(() -> page.click("#btnFileUpload"));
//        fileChooser.setFiles(Paths.get("C://Users//Cormsquare//Downloads//ImportRequisitionItems (4).xlsx"));
    }
    public void TypeOfPurchase(){
        page.locator("#select2-typeOfPurchaseId-container").click();
        Locator typeOfPurchase = page.locator("//li[contains(text(),'" + properties.getProperty("TypeOfPurchase") + "')]");
        typeOfPurchase.click();
    }
    public void PriceValidity(){
        page.getByLabel("-- Select Price Validity --").click();
        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("PriceValidity"));
        Locator getPriceValidity = page.locator("//li[contains(text(),'" + properties.getProperty("PriceValidity") + "')]");
        getPriceValidity.click();
    }

    public void InspectionRequired() {
        page.locator("//label[contains(@for,'inspect') and contains(text(),'Yes')]").click();
    }

    //    public void AddLineRequisitionItems() {
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add line Requisition Items")).click();
////TODO Category
//        page.getByLabel("-- Select Categories --").click();
//        page.getByRole(AriaRole.SEARCHBOX).fill(properties.getProperty("Category"));
//        Locator getCategory = page.locator("//li[contains(text(),'" + properties.getProperty("Category") + "')]").first();
//        getCategory.click();
////TODO Items
//        page.getByLabel("-- Select Item --").click();
//        Locator getItem = page.locator("//li[contains(text(),'" + properties.getProperty("Item") + "')]").first();
//        getItem.click();
////TODO Quantity
//        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("* Quantity :")).click();
//        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("* Quantity :")).fill(String.valueOf(properties.getProperty("Quantity")));
////TODO Add Button
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add").setExact(true)).click();
//    }
    public void AddLineRequisitionItems() {

        if(page.locator("//tbody[@id='requisitionItems-container']/tr").count()>0)
        {
            page.locator("//tbody[@id='requisitionItems-container']/tr/td//a[@id='deleterequisitionitem']").click();
        }



        page.locator("#addLineRequisitionItems").click();
        //TODO Item Select
        page.locator("//span[contains(@id,'select2-item')]").click();
        page.locator(".select2-search__field").fill(properties.getProperty("Item"));
        Locator getItem = page.locator("//li[contains(text(),'" + properties.getProperty("Item") + "')]").first();
        getItem.click();
        //TODO Quantity
        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("* Quantity :")).click();
        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("* Quantity :")).fill(String.valueOf(properties.getProperty("Quantity")));
        //TODO Add Button
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add").setExact(true)).click();
    }
    public abstract void ImportItems();
    public void Notes() {
        page.getByPlaceholder("Please Enter Notes").click();
        page.getByPlaceholder("Please Enter Notes").fill(properties.getProperty("Notes"));
    }
    public void NotesAttachments(){
        //Internal
        page.locator("#attachDocs").click();
        Locator CommercialFile = page.locator("#formFilePreupload");
        CommercialFile.setInputFiles(Paths.get("Attachments-and-import-files/Internal Attachment.xlsx"));
        page.locator("#radioActive").click();
        page.locator("#saveAttachments1").click();
        //External
        CommercialFile.setInputFiles(Paths.get("Attachments-and-import-files/External Attachment.xlsx"));
        page.locator("#radioInActive").click();
        page.locator("#saveAttachments1").click();
        //Internal Link
        page.locator("#formCheck12").check();
        page.locator("#sm_documentUrl").fill(properties.getProperty("InternalLink"));
        page.locator("#name").fill("Internal link");
        page.locator("#saveAttachments1").click();
        //External Link
        page.locator("#formCheck12").check();
        page.locator("#sm_documentUrl").fill(properties.getProperty("ExternalLink"));
        page.locator("#name").fill("External link");
        page.locator("#saveAttachments1").click();
        page.locator("#submitAttachmentsId").click();
    }

    public void PRCreate() throws InterruptedException {
//TODO Create Draft Button
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Draft")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
        Thread.sleep(1000);
        logoutPageInterface.LogoutMethod();
    }

}
