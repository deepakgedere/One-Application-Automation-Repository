package com.procurement.positiveFlowTest;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class nonCatalogPositiveTestFlow extends BaseTest {
    @Test
    public void PositiveFlowTestMethod(){
        try {
            prCreateMethod();
            prSendForApproval.NonCatalogPrSendForApproval();
            prAssign.BuyerManagerAssign();
            rfqCreateMethod();
            quotationSubmit.InviteRegisteredVendor();
            quotationCreateMethod();
            readyForEvalutationInterface.ReadyForEvaluationButton();
            technicalEvaluationInterface.TechnicalEvaluationButton();
            commercialEvaluationInterface.CommercialEvaluationButton();
            porCreateMethod();
            porApproval.NonCatalogPORSendForApproval();
            porApprove.AllApprove();
            porInspectPoInterface.InspectCreatePO();
//            purchaseOrderInterface.SendForVendor();
//            orderScheduleInterface.OSCreate();
//            orderScheduleApproveInterface.OSApprove();
//            inspectionCreateInterface.VendorInspectionCreate();
//            inspectionAssignInterface.RequesterInspectionAssign();
//            dispatchNoteCreateInterface.DNCreate();
//            dispatchNotesAssignInterface.DNAssign();
//            workOrderCreateInterface.WOCreate();
//            woSendForApprovalInterface.SendForApproval();
//            woApproveInterface.WOApproveMethod();
//            woTrackerStatusInterface.VendorTrackerStatus();
//            woOkForInvoiceInterface.WOOkForInvoiceMethod();
//            poInvoiceCreateInterface.VendorCreatePOInvoice();
//            poSendForApprovalInterface.SendForApproval();
//            poInvoiceApprovalInterface.POInvoiceAllApprove();
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    private void prCreateMethod() throws InterruptedException {
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
    }
    private void rfqCreateMethod() throws InterruptedException{
        rfqCreate.BuyerRfqCreate();
        rfqCreate.RfQNotes();
        rfqCreate.RFQCreate();
    }
    private void quotationCreateMethod() throws InterruptedException{
        quotationSubmit.VendorLogin();
        quotationSubmit.Compliances();
        quotationSubmit.QuotationItems();
        quotationSubmit.QuotationAttachments();
        quotationSubmit.QuotationSubmitButton();
    }
    private void porCreateMethod() throws InterruptedException{
        porCreateNonCatalog.BuyerPORCreate();
        porCreateNonCatalog.Justification();
        porCreateNonCatalog.PORNotes();
        porCreateNonCatalog.TaxCode();
        porCreateNonCatalog.PORCreate();
    }
}
