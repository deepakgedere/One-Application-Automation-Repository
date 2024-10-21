package com.interfaces.procurementInterfaces.Invoice;

public interface POInvoiceApprovalInterface {

    void POInvoiceApprovalMethod(String approverEmail, int i) throws InterruptedException;
    void POInvoiceAllApprove();
}