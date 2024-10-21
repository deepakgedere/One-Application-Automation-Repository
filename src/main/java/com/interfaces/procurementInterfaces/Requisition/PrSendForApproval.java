package com.interfaces.procurementInterfaces.Requisition;

import java.util.List;

public interface PrSendForApproval {
    void NonCatalogPrSendForApproval() throws InterruptedException;
    List<String> GetPRApprovers() throws InterruptedException;
    String GetPRReferenceNumber();
}