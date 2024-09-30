package com.procurement.positiveFlowTest;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class nonCatalogPositiveTestFlow extends BaseTest {
    @Test
    public void PositiveFlowTestMethod(){
        try {
            prCreateNonCatalog.RequesterLoginPRCreate();
            prCreateNonCatalog.CreateButton();
            prCreateNonCatalog.NonCatalog();
            prCreateNonCatalog.Title();
            prCreateNonCatalog.Project();
            prCreateNonCatalog.WBS();
            prCreateNonCatalog.Incoterm();
            prCreateNonCatalog.ShippingAddress();
            prCreateNonCatalog.ShippingMode();
            prCreateNonCatalog.QuotationRequiredBy();
            prCreateNonCatalog.ExpectedPOIssue();
            prCreateNonCatalog.ExpectedDelivery();
            prCreateNonCatalog.ProjectManager();
            prCreateNonCatalog.BuyerManager();
            prCreateNonCatalog.PriceValidity();
            prCreateNonCatalog.InspectionRequired();
            prCreateNonCatalog.OrderIntake();
            prCreateNonCatalog.TargetPrice();
            prCreateNonCatalog.Tcas();
            prCreateNonCatalog.TcasCheck();
            prCreateNonCatalog.TcasFileUpload();
            prCreateNonCatalog.WarrantyRequirements();
            prCreateNonCatalog.ImportItems();
            prCreateNonCatalog.AddLineRequisitionItems();
            prCreateNonCatalog.Notes();
            prCreateNonCatalog.NotesAttachments();
            prCreateNonCatalog.PRCreate();
            prSendForApproval.NonCatalogPrSendForApproval();
            prAssign.BuyerManagerAssign();
            rfqCreate.BuyerRfqCreate();
            rfqCreate.RfQNotes();
            rfqCreate.RFQCreate();
            quotationSubmit.InviteRegisteredVendor();
            quotationSubmit.VendorLogin();
            quotationSubmit.Compliances();
            quotationSubmit.QuotationItems();
            quotationSubmit.QuotationAttachments();
            quotationSubmit.QuotationSubmitButton();
            readyForEvalutationInterface.ReadyForEvaluationButton();
            technicalEvaluationInterface.TechnicalEvaluationButton();
            commercialEvaluationInterface.CommercialEvaluationButton();
            porCreateNonCatalog.BuyerPORCreate();
            porCreateNonCatalog.Justification();
            porCreateNonCatalog.PORNotes();
            porCreateNonCatalog.TaxCode();
            porCreateNonCatalog.PORCreate();
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
}
