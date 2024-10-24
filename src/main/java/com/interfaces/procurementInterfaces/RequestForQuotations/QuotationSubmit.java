package com.interfaces.procurementInterfaces.RequestForQuotations;

public interface QuotationSubmit {
    void InviteRegisteredVendor();
    void VendorLogin() throws InterruptedException;
    void Compliances();
    void QuotationItems();
//    void Gst();
    void QuotationAttachments();
    void QuotationSubmitButton();

    void QuotationSubmit() throws InterruptedException;
}
