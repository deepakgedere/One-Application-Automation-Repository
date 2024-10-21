package com.interfaces.procurementInterfaces.Requisition;

public interface PrReject {

    void Reject(String ApproverEmail, String PRReferenceNumber) throws InterruptedException;
}