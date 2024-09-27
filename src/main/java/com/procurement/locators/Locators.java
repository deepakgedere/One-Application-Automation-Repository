package com.procurement.locators;

import com.microsoft.playwright.Locator;

public class Locators {

    //Login Page
    private static String loginEmailLocator = "//input[@id='Input_Email']";
    private static String passwordLocator = "//input[@id='Input_Password']";
    private static String loginButtonLocator = "//button[@id='login-submit']";


    //POC PR Create
    private static String titleLocator = "//input[@id='title']";


    public static String loginEmailLocator() { return loginEmailLocator; }
    public static String passwordLocator() { return passwordLocator; }
    public static String loginButtonLocator() { return loginButtonLocator; }

    public static String titleLocator() { return titleLocator; }
}
