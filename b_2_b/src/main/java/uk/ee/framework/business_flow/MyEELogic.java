package uk.ee.framework.business_flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import uk.ee.framework.business_objects.dao.Payment;
import uk.ee.framework.business_objects.dao.credit_card.CreditCard;
import uk.ee.framework.business_objects.dao.direct_debit.DirectDebit;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.pages.my_ee.AccountSettings;
import uk.ee.framework.pages.my_ee.BillsAndPayments;
import uk.ee.framework.pages.my_ee.Dashboard;
import uk.ee.framework.pages.my_ee.HomePage;
import uk.ee.framework.pages.my_ee.PacksAndAddons;
import uk.ee.framework.pages.my_ee.PlansAndAddOns;
import uk.ee.framework.pages.my_ee.TopUp;
import uk.ee.framework.pages.my_ee.TopUpHistory;
import uk.ee.framework.pages.my_ee.ManageDevice;
import uk.ee.framework.pages.my_ee.UsagePage;

/**
 * Modified by prabhu_s on 08/02/16. 
 */
@Component
@Scope("prototype")
public class MyEELogic {

    @Autowired HomePage homePage;
    @Autowired BillsAndPayments billsAndPayments;
    @Autowired Dashboard dashboard;
    @Autowired ManageDevice manageDevice;
    @Autowired AccountSettings accountSettings;
    @Autowired UsagePage usagePage;
    @Autowired TopUpHistory topUpHistory;
    @Autowired TopUp topUp;
    @Autowired PacksAndAddons packAndAddons; 
    @Autowired PlansAndAddOns plansAndAddOns;
    
	public void existingUserPayBillWithExistingCreditCard(final User user, final Payment payment,
			final PaymentDetails pdObj, final String card) {
		homePage.launchMyee();
		homePage.login(user);
		dashboard.clickMenuBillsAndPayments();
		// dashboard.clickPayment();
		billsAndPayments.makeExtUserPayBillWithExtCC(payment, pdObj, card);
	}
    
    public void existingUseryTopUpExistingCreditCard(User user){
    	homePage.launchMyee();
        homePage.login(user);
        dashboard.clickTopUpBtn();
        topUp.topUpExistingCard();
    }
    
    public void existingUseryTopUpNewCreditCard(User user, CreditCard creditCard){
    	homePage.launchMyee();
        homePage.login(user);
        dashboard.clickTopUpBtn();
        topUp.topUpNewCard(creditCard);
    }
    
   
    public boolean newDirectDebitRegistration(User user, DirectDebit debit) {
    	homePage.launchMyee();
    	homePage.login(user);
		dashboard.clickMenuBillsAndPayments();
		boolean status = billsAndPayments.setupDD(debit);
		return status;
	}
    
    public void editDirectDebitRegistration(User user, DirectDebit debit) {
    	homePage.launchMyee();
    	homePage.login(user);
		dashboard.clickMenuBillsAndPayments();
		billsAndPayments.editAndSaveDirectDebit(debit);
	}

    public String checkAllowances(User user){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickUsage();
    	usagePage.closeThePopUp("no");
    	String allowance = usagePage.viewAllowances();
    	usagePage.viewAllowanceDetails();
    	usagePage.viewDataPasses();
    	return allowance;
    }

    
    public String viewTopUpHistory(User user) {
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickTopUpHistory();
    	return topUpHistory.viewTopUpHistory();
    }
    
    public void viewCurrentCredit(User user) {
    	homePage.login(user);
    	dashboard.viewCurrentCredit();
    }
    
    public void viewPackInfo(User user) {
    	homePage.login(user);
    	dashboard.viewPackInfo();
    }
    
    public void setTopUpAlertsForPayg(User user, String amount){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuAccountSettings();
    	accountSettings.setupPAYGAlert(amount);
    }   

    public void allowContentLock(String status, User user) {
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuManageDevice();
    	manageDevice.manageContentLock(status);
	}

    public String validateRemainingAllowance(User user) {
    	homePage.login(user);
    	return dashboard.remainingAllowances();
	}
    
    public void updateDeviceControls(User user, String status, String addOn){
    	homePage.launchMyee();
    	homePage.login(user);
    	
    	dashboard.clickMenuManageDevice();
    	manageDevice.deviceUsageControls(status, addOn);
    	
    }
    public void removeRegisteredCard(User user) {
       	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickTopUpBtn();
    	topUp.manageCards();
    }
    
    public String validateAllowanceDetails(User user) {
    	homePage.launchMyee();
    	homePage.login(user);
    	return dashboard.viewPayGAllowances();
    }
    
    public boolean validateUsageDetails(User user) {
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuPackAndAddOns();
    	return (packAndAddons.viewUsage());
    }

    public void validatePaygMbbUser(User user) {
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.validatePaygMbbUser();
    }
    public void purchasePayGPacks(User user){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuPackAndAddOns();
    	packAndAddons.packTab();
    }
    
    public void dashboardPagePayM(User user){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.viewDevicesAndPlansPayM();
    	dashboard.getBillDetails();
    }
    
    public void dashboardPageSB(User user){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.viewDevicesAndPlansSB();
    	dashboard.getBillDetails();
    	System.out.println("Device details, plans and Bill details are validated Successfully");
    }
    
    public void dashboardPagePayG(User user){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.viewCurrentCredit();
    	dashboard.viewPackInfo();
    }
    
    public void removeAddonsPayM(User user) {
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuPackAndAddOns();
    	plansAndAddOns.selectRemoveAddons();
    }
    
    public void buyAddonsPayM(User user) {
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuPackAndAddOns();
    	plansAndAddOns.selectBuyAddons();
    }
    
    public void setBillsAlertsForPaym(User user, String alertType){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuAccountSettings();
    	accountSettings.setupPaymAlert(alertType);
    } 
    
    public void viewBillDetailsPayM(User user){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuBillsAndPayments();
    	System.out.println(billsAndPayments.viewBillInfo());
    	Assert.assertNotNull(billsAndPayments.viewBillInfo());
    } 
    
    public void viewBillDetailsSB(User user){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuInvoiceAndPayments();
    	billsAndPayments.viewBillInfo();
    } 
    
    public String viewAllowancesSB(User user){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuCurrentUsage();
    	usagePage.viewAllowances();
    	String allowanceDetails = usagePage.viewAllowanceDetails();
    	usagePage.viewDataPasses();
    	return allowanceDetails;
    } 
   
    public void buyAddonsPayG(User user) {
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuPackAndAddOns();
    	packAndAddons.buyAddons();
    }
    
    public void updateGroupUsage(User user, String status){
    	homePage.launchMyee();
    	homePage.login(user);
    	dashboard.clickMenuManageDevice();
    	manageDevice.groupUsageControls(status);
    }
}