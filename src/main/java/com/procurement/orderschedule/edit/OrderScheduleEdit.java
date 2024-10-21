package com.procurement.orderschedule.edit;
import com.interfaces.procurementInterfaces.Login.LoginPageInterface;
import com.interfaces.procurementInterfaces.Logout.LogoutPageInterface;
import com.interfaces.procurementInterfaces.OrderSchedule.OSEdit;
import com.microsoft.playwright.Page;
import java.util.List;
import java.util.Properties;

public class OrderScheduleEdit implements OSEdit {

    Properties properties;
    Page page;
    LoginPageInterface loginPageInterface;
    LogoutPageInterface logoutPageInterface;

    private OrderScheduleEdit(){
    }

    //TODO Constructor
    public OrderScheduleEdit(LoginPageInterface loginPageInterface, Properties properties, Page page, LogoutPageInterface logoutPageInterface){
        this.loginPageInterface = loginPageInterface;
        this.properties = properties;
        this.page = page;
        this.logoutPageInterface = logoutPageInterface;
    }

    public void OSEditMethod(){
        loginPageInterface.LoginMethod(properties.getProperty("VendorMailId"));
        page.locator("//*[contains(text(), 'Order Schedules')]").click();
        String poReferenceId = properties.getProperty("PoReferenceId");
        List<String> containerList = page.locator("#listContainer tr td").allTextContents();
        for(String tr : containerList){
            if(tr.contains(poReferenceId)){
                page.locator(".btn-link").first().click();
            }
        }
        page.locator("#btnEdit").click();
        page.locator("#btnUpdate").click();
        page.locator(".bootbox-accept").click();
        logoutPageInterface.LogoutMethod();
    }
}