package com.procurement.locators;

import com.microsoft.playwright.Locator;

public class Locators {

    //Login Page
    private static String loginEmailLocator = "//input[@id='Input_Email']";
    private static String passwordLocator = "//input[@id='Input_Password']";
    private static String loginButtonLocator = "//button[@id='login-submit']";

    //POC PR Create
    private static String requisitionsNavLocator = "//a[contains(@class,'nav-link') and contains(@href,'Requisitions')]";
    private static String createBtnLocator = "//button[@data-bs-target='#createPRModal']";
    private static String nonCatalogLocator = "//tbody/tr[2]/td[1]/a[1]";
    private static String catalogLocator = "//tbody/tr[1]/td[1]/a[1]";
    private static String titleLocator = "//input[@id='title']";
    private static String shipToYokogawaLocator = "//input[@id='shipToYokogawa']";






    public static String loginEmailLocator() { return loginEmailLocator; }
    public static String passwordLocator() { return passwordLocator; }
    public static String loginButtonLocator() { return loginButtonLocator; }

    public static String requisitionsNavLocator() { return requisitionsNavLocator; }
    public static String createBtnLocator() { return createBtnLocator; }
    public static String nonCatalogLocator() { return nonCatalogLocator; }
    public static String catalogLocator() { return catalogLocator; }
    public static String titleLocator() { return titleLocator; }
    public static String shipToYokogawaLocator() { return shipToYokogawaLocator; }




}
