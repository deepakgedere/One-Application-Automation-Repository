package com.interfaces.procurementInterfaces.Requisition;

public interface PrApprove {
    void Approve();
    void Approve(String approverMailId);
    void Approve(String approverMailId, String PRReferenceNumber) throws InterruptedException;
}