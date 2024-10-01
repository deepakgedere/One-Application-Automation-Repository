package com.procurement.requisition.create;
import com.base.BaseTest;
import org.testng.annotations.Test;

public class catalogPrCreateTest extends BaseTest {

    @Test (priority = 1, groups = "requisition")
    public void CatalogPrCreateMethod(){
        try{
            catalogPrCreate.RequesterLoginPRCreate();
            catalogPrCreate.CreateButton();
            catalogPrCreate.PrType();
            catalogPrCreate.Title();
            catalogPrCreate.Project();
            catalogPrCreate.WBS();
            catalogPrCreate.VendorSelection();
            catalogPrCreate.RateContract();
            catalogPrCreate.ShippingAddress();
            catalogPrCreate.ShippingMode();
            catalogPrCreate.ExpectedPOIssue();
            catalogPrCreate.ExpectedDelivery();
            catalogPrCreate.ProjectManager();
            catalogPrCreate.BuyerManager();
            catalogPrCreate.InspectionRequired();
            catalogPrCreate.OrderIntake();
            catalogPrCreate.Tcas();
            catalogPrCreate.TcasCheck();
            catalogPrCreate.TcasFileUpload();
            catalogPrCreate.ImportItems();
            catalogPrCreate.AddLineRequisitionItems();
            catalogPrCreate.Notes();
            catalogPrCreate.NotesAttachments();
            catalogPrCreate.PRCreate();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}