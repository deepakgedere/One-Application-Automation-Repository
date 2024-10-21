package com.procurement.requisition.create;

import com.interfaces.procurementInterfaces.Login.LoginPageInterface;
import com.interfaces.procurementInterfaces.Logout.LogoutPageInterface;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;

import java.nio.file.Paths;
import java.util.Properties;

public class catalogPrCreate extends prCreateAbstract{

    public catalogPrCreate(LoginPageInterface loginPageInterface, Properties properties, Page page, LogoutPageInterface logoutPageInterface) {
        super(loginPageInterface, properties, page, logoutPageInterface);
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
}
