package com.procurement.positiveFlowTest;

import com.base.BaseTest;
import org.testng.annotations.Test;
import com.procurement.positiveFlowTest.catalogPositiveTestFlow;
public class catalogPositiveTestFlow extends BaseTest {


    @Test
    public void PositiveFlowTestMethod(){
        try {
            catalogPrCreate.CatalogCreate();
//            prCreateMethod();
            prSendForApproval.NonCatalogPrSendForApproval();
            prAssign.BuyerManagerAssign();
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
        porCreateCatalog.BuyerPORCreate();
        porCreateNonCatalog.PORNotes();
        porCreateNonCatalog.TaxCode();
        porCreateNonCatalog.PORCreate();
    }
}
