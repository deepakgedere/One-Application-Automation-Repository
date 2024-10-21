package com.interfaces.procurementInterfaces.Login;
import com.microsoft.playwright.Page;

public interface LoginPageInterface {
    void LoginMethod();
    void LoginMethod(String approverMailId);
    void LoginMethod(String approverMailId, Page page);
}