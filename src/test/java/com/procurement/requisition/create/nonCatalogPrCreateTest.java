package com.procurement.requisition.create;
import com.base.BaseTest;
import org.testng.annotations.Test;

public class nonCatalogPrCreateTest extends BaseTest {

    @Test (priority = 1, groups = "requisition")
    public void NonCatalogPrCreateMethod(){
        try{
            nonCatalogPrCreate.RequesterLoginPRCreate();
            nonCatalogPrCreate.CreateButton();
            nonCatalogPrCreate.PrType();
            nonCatalogPrCreate.Title();
            nonCatalogPrCreate.Project();
            nonCatalogPrCreate.WBS();
            nonCatalogPrCreate.Incoterm();
            nonCatalogPrCreate.ShippingAddress();
            nonCatalogPrCreate.ShippingMode();
            nonCatalogPrCreate.QuotationRequiredBy();
            nonCatalogPrCreate.ExpectedPOIssue();
            nonCatalogPrCreate.ExpectedDelivery();
            nonCatalogPrCreate.ProjectManager();
            nonCatalogPrCreate.BuyerManager();
            nonCatalogPrCreate.PriceValidity();
            nonCatalogPrCreate.InspectionRequired();
            nonCatalogPrCreate.OrderIntake();
            nonCatalogPrCreate.TargetPrice();
            nonCatalogPrCreate.Tcas();
            nonCatalogPrCreate.TcasCheck();
            nonCatalogPrCreate.TcasFileUpload();
            nonCatalogPrCreate.WarrantyRequirements();
            nonCatalogPrCreate.ImportItems();
            nonCatalogPrCreate.AddLineRequisitionItems();
            nonCatalogPrCreate.Notes();
            nonCatalogPrCreate.NotesAttachments();
            nonCatalogPrCreate.PRCreate();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}