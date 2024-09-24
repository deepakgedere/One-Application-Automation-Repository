package com.procurement.requisition.create;
import com.base.BaseTest;
import org.testng.annotations.Test;

public class NonCatalogPrCreateTest extends BaseTest {

    @Test (priority = 1, groups = "requisition")
    public void NonCatalogPrCreateMethod(){
        try{
            prCreateNonCatalog.RequesterLoginPRCreate();
            prCreateNonCatalog.CreateButton();
            prCreateNonCatalog.NonCatalog();
            prCreateNonCatalog.Title();
            prCreateNonCatalog.Project();
            prCreateNonCatalog.WBS();
            prCreateNonCatalog.Incoterm();
//            prCreateNonCatalog.LiquidatedDamages();
//            prCreateNonCatalog.PriceValidity();
//            prCreateNonCatalog.ShipToYokogawa();
            prCreateNonCatalog.ShippingAddress();
//            prCreateNonCatalog.StorageLocation();
            prCreateNonCatalog.ShippingMode();
            prCreateNonCatalog.QuotationRequiredBy();
            prCreateNonCatalog.ExpectedPOIssue();
            prCreateNonCatalog.ExpectedDelivery();
            prCreateNonCatalog.ProjectManager();
            prCreateNonCatalog.BuyerManager();
//            prCreateNonCatalog.BuyerGroup();
//            prCreateNonCatalog.RoHS();
            prCreateNonCatalog.PriceValidity();
            prCreateNonCatalog.InspectionRequired();
//            prCreateNonCatalog.Checker();
            prCreateNonCatalog.OrderIntake();
            prCreateNonCatalog.TargetPrice();
            prCreateNonCatalog.Tcas();
            prCreateNonCatalog.TcasCheck();
            prCreateNonCatalog.TcasFileUpload();
            prCreateNonCatalog.WarrantyRequirements();
//            prCreateNonCatalog.TypeOfPurchase();
            prCreateNonCatalog.ImportItems();
            prCreateNonCatalog.AddLineRequisitionItems();
            prCreateNonCatalog.Notes();
            prCreateNonCatalog.NotesAttachments();
            prCreateNonCatalog.PRCreate();



        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}