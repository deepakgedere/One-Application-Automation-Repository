package com.procurement.login;

import com.interfaces.LoginPageInterface;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.procurement.locators.Locators;

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
        Locator mailId = page.locator(Locators.loginEmailLocator());
        mailId.click();
        mailId.fill(properties.getProperty("EmailID"));
        Locator password = page.locator(Locators.passwordLocator());
        password.click();
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator(Locators.loginButtonLocator());
        loginButton.click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

    public void LoginMethod(String getMailId) {
        Locator mailId = page.locator(Locators.loginEmailLocator());
        mailId.click();
        mailId.fill(getMailId);
        Locator password = page.locator(Locators.passwordLocator());
        password.click();
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator(Locators.loginButtonLocator());
        loginButton.click();
    }

    public void LoginMethod(String getMailId, Page page) {
        Locator mailId = page.locator(Locators.loginEmailLocator());
        mailId.click();
        mailId.fill(getMailId);
        Locator password = page.locator(Locators.passwordLocator());
        password.click();
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator(Locators.loginButtonLocator());
        loginButton.click();
    }
}