package com.procurement.positiveFlowTest;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class catalogPositiveTestFlow extends BaseTest {
    @Test
    public void PositiveFlowTestMethod(){
        try {
            prCreateCatalog.RequesterLoginPRCreate();
            prCreateCatalog.CreateButton();
            prCreateCatalog.NonCatalog();
            prCreateCatalog.Title();
            prCreateCatalog.Project();
            prCreateCatalog.WBS();
            prCreateCatalog.VendorSelection();
            prCreateCatalog.RateContract();
            prCreateCatalog.ShippingAddress();
            prCreateCatalog.ShippingMode();
            prCreateCatalog.ExpectedPOIssue();
            prCreateCatalog.ExpectedDelivery();
            prCreateCatalog.ProjectManager();
            prCreateCatalog.BuyerManager();
            prCreateCatalog.InspectionRequired();
            prCreateCatalog.OrderIntake();
            prCreateCatalog.Tcas();
            prCreateCatalog.TcasCheck();
            prCreateCatalog.TcasFileUpload();
            prCreateCatalog.ImportItems();
            prCreateCatalog.AddLineRequisitionItems();
            prCreateCatalog.Notes();
            prCreateCatalog.NotesAttachments();
            prCreateCatalog.PRCreate();
            prSendForApproval.NonCatalogPrSendForApproval();
            prAssign.BuyerManagerAssign();
            porCreateCatalog.BuyerPORCreate();
            porCreateNonCatalog.PORNotes();
            porCreateNonCatalog.TaxCode();
//            porCreateNonCatalog.PORCreate();
//            porApproval.NonCatalogPORSendForApproval();
//            porApprove.AllApprove();
//            porInspectPoInterface.InspectCreatePO();
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
