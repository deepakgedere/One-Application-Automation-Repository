package com.interfaces.procurementInterfaces.PurchaseOrderRequest;

public interface PorSuspend {

    void SuspendPorEdit() throws InterruptedException;
    void SuspendRfqEdit() throws InterruptedException;
}