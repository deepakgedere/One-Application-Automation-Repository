package com.procurement.requisition.create;

import com.interfaces.procurementInterfaces.Login.LoginPageInterface;
import com.interfaces.procurementInterfaces.Logout.LogoutPageInterface;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;
import java.util.Properties;

public class nonCatalogPrCreate extends prCreateAbstract{

    public nonCatalogPrCreate(LoginPageInterface loginPageInterface, Properties properties, Page page, LogoutPageInterface logoutPageInterface) {
        super(loginPageInterface, properties, page, logoutPageInterface);
    }

    public void NonCatalogCreate() throws InterruptedException {
        RequesterLoginPRCreate();
        CreateButton();
        PrType();
        Title();
        Project();
        WBS();
        Incoterm();
        ShippingAddress();
        ShippingMode();
        QuotationRequiredBy();
        ExpectedPOIssue();
        ExpectedDelivery();
        ProjectManager();
        BuyerManager();
        PriceValidity();
        InspectionRequired();
        OrderIntake();
        TargetPrice();
        Tcas();
        TcasCheck();
        TcasFileUpload();
        WarrantyRequirements();
        ImportItems();
        AddLineRequisitionItems();
        Notes();
        NotesAttachments();
        PRCreate();
    }

    @Override
    public void PrType(){
        page.locator("//tbody/tr[2]/td[1]/a[1]").click();
    }

    @Override
    public void ImportItems(){
        page.locator("#importItem").click();
        Locator CommercialFile = page.locator("#formFile");
        CommercialFile.setInputFiles(Paths.get("Attachments-and-import-files/ImportRequisitionItem.xlsx"));
        page.locator("#btnUpload").click();
    }



    @Override
    public void VendorSelection() {

    }

    @Override
    public void RateContract() {

    }


}
