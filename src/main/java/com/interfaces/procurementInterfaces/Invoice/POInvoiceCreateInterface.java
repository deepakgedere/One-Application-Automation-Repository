package com.interfaces.procurementInterfaces.Invoice;

public interface POInvoiceCreateInterface {

    void VendorCreatePOInvoice() throws InterruptedException;
    double VendorGST();
    void SGDEquivalentEnable(double finalGSTPercentage);
}