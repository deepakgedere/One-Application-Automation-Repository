package com.procurement.login;

import com.interfaces.procurementInterfaces.Login.LoginPageInterface;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.procurement.loc.loc;
import com.procurement.loc.login.loginLocators;

import java.util.Properties;

public class LoginPage implements LoginPageInterface {

    Page page;
    Properties properties;

    private LoginPage(){
    }

//TODO Constructor
    public LoginPage(Properties properties, Page page){
        this.properties = properties;
        this.page = page;
    }

    public void LoginMethod() {
        Locator mailId = page.locator(loginLocators.loginEmailLocator);
        mailId.click();
        mailId.fill(properties.getProperty("EmailID"));
        Locator password = page.locator(loginLocators.loginPasswordLocator);
        password.click();
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator(loginLocators.loginSubmitLocator);
        loginButton.click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

    public void LoginMethod(String getMailId) {
        Locator mailId = page.locator(loginLocators.loginEmailLocator);
        mailId.click();
        mailId.fill(getMailId);
        Locator password = page.locator(loginLocators.loginPasswordLocator);
        password.click();
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator(loginLocators.loginSubmitLocator);
        loginButton.click();
    }

    public void LoginMethod(String getMailId, Page page) {
        Locator mailId = page.locator(loginLocators.loginEmailLocator);
        mailId.click();
        mailId.fill(getMailId);
        Locator password = page.locator(loginLocators.loginPasswordLocator);
        password.click();
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator(loginLocators.loginSubmitLocator);
        loginButton.click();
    }
}