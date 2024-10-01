package com.procurement.requisition.create;

import com.interfaces.LoginPageInterface;
import com.interfaces.LogoutPageInterface;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.procurement.locators.Locators;

import java.nio.file.Paths;
import java.util.Properties;

public class nonCatalogPrCreate extends prCreateAbstract{

    public nonCatalogPrCreate(LoginPageInterface loginPageInterface, Properties properties, Page page, LogoutPageInterface logoutPageInterface) {
        super(loginPageInterface, properties, page, logoutPageInterface);
    }

    @Override
    public void PrType(){
        page.locator(Locators.nonCatalogLocator()).click();
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
