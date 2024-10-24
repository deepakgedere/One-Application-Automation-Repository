package com.procurement.positiveFlowTest;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class nonCatalogPositiveTestFlow extends BaseTest {
    @Test
    public void PositiveFlowTestMethod(){
        try {
            nonCatalogPrCreate.NonCatalogCreate();
            prSendForApproval.NonCatalogPrSendForApproval();
            prAssign.BuyerManagerAssign();
            rfqCreate.RfqCreateCombined();
            quotationSubmit.InviteRegisteredVendor();
            quotationSubmit.QuotationSubmit();
            readyForEvalutationInterface.ReadyForEvaluationButton();
            technicalEvaluationInterface.TechnicalEvaluationButton();
            commercialEvaluationInterface.CommercialEvaluationButton();
            porCreateMethod();
            porApproval.NonCatalogPORSendForApproval();
            porApprove.AllApprove();
            porInspectPoInterface.InspectCreatePO();
            purchaseOrderInterface.SendForVendor();
            orderScheduleInterface.OSCreate();
            orderScheduleApproveInterface.OSApprove();
            inspectionCreateInterface.VendorInspectionCreate();
            inspectionAssignInterface.RequesterInspectionAssign();
            dispatchNoteCreateInterface.DNCreate();
            dispatchNotesAssignInterface.DNAssign();
            workOrderCreateInterface.WOCreate();
            woSendForApprovalInterface.SendForApproval();
            woApproveInterface.WOApproveMethod();
            woTrackerStatusInterface.VendorTrackerStatus();
            woOkForInvoiceInterface.WOOkForInvoiceMethod();
            poInvoiceCreateInterface.VendorCreatePOInvoice();
            poSendForApprovalInterface.SendForApproval();
            poInvoiceApprovalInterface.POInvoiceAllApprove();
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    private void porCreateMethod() throws InterruptedException{
        porCreateNonCatalog.BuyerPORCreate();
        porCreateNonCatalog.Justification();
        porCreateNonCatalog.PORNotes();
        porCreateNonCatalog.TaxCode();
        porCreateNonCatalog.PORCreate();
    }
}
