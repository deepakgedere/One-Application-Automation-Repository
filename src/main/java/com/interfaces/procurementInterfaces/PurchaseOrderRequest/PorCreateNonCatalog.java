package com.interfaces.procurementInterfaces.PurchaseOrderRequest;

public interface PorCreateNonCatalog {
    void BuyerPORCreate();
    void Justification();
    void TaxCode();
    void PORNotes();
    void PORCreate() throws InterruptedException;
}
