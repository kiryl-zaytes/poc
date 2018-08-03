package uk.ee.framework.pages.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.business_objects.dao.billing_details.BillingDetails;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.elements.sections.shop.ConfirmationPopUp;
import uk.ee.framework.elements.sections.shop.ExistingCustomer;
import uk.ee.framework.elements.sections.shop.PersonalDetails;
import uk.ee.framework.elements.sections.shop.TermsAndConditions;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 06/16/2016
 * 
 * This is a checkout flow which is common for all the different scenarios.
 * 
 */
@Component
@Scope("prototype")
public class Checkout extends BasePage {
	@FindBy(css = "div.content-container")
	ExistingCustomer existingCustomer;

	@FindBy(css = "div.content-container")
	PersonalDetails personalDetails;

	@FindBy(css = "div.content-container")
	uk.ee.framework.elements.sections.shop.BillingDetails billingDetails;

	@FindBy(css = "div.content-container")
	TermsAndConditions termsAndConditions;

	@FindBy(css = "form#payment")
	uk.ee.framework.elements.sections.shop.PaymentDetails paymentDetails;

	@FindBy(css = "div.cart-designation")
	WebElement yourBasket;

	@FindBy(css = "iframe.tccIFrame")
	WebElement iframePayment;

	@FindBy(css = "iframe.secure3DIFrame.visible")
	WebElement threeDSecureiframePayment;

	@Autowired
	ThreeDSecure formthreeDSecure;
	
	@FindBy(xpath = "//*[@id='oo_invitation_prompt']")
	ConfirmationPopUp popUp;
	
	/**
	 * This method is used to checkout the paym new customer order.
	 * 
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void checkOutNewCustomer(final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedPersonalDetails(customerObj);
		if (null != existingCustomer.checkGlobalMsgAndContinue())
		{
			personalDetails.continueToNext();
		}
		billingDetails.proceedBillingDetails(bdObj);
		termsAndConditions.agreeTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		waiter.switchtoframe(threeDSecureiframePayment);
		formthreeDSecure.threeDSubmit();
		closeThePopUp("no");
	}

	/**
	 * This method is used to checkout the payg new customer order.
	 * 
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void checkOutPaygCustomer(final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedPaygPersonalDetails(customerObj);
		termsAndConditions.agreeTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		waiter.switchtoframe(threeDSecureiframePayment);
		formthreeDSecure.threeDSubmit();
		closeThePopUp("no");
	}

	/**
	 * This method is used to checkout the paym RSA new customer order.
	 * 
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void checkOutRSANewCustomer(final String customerType, final Customer customerObj,
			final BillingDetails bdObj, final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedPersonalDetails(customerObj);
		billingDetails.proceedBillingDetails(bdObj);
		termsAndConditions.agreeTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		closeThePopUp("no");
	}

	/**
	 * This method is used to checkout the payg RSA new customer order.
	 * 
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void checkOutRSAPaygCustomer(final String customerType, final Customer customerObj,
			final BillingDetails bdObj, final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedPaygPersonalDetails(customerObj);
		termsAndConditions.agreeTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		closeThePopUp("no");
	}

	/**
	 * This method is used to checkout the paym SIMO new customer order.
	 * 
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void checkOutSIMONewCustomer(final String customerType, final Customer customerObj,
			final BillingDetails bdObj, final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedSIMOPersonalDetails(customerObj);
		billingDetails.proceedBillingDetails(bdObj);
		termsAndConditions.agreeSIMOTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		waiter.switchtoframe(threeDSecureiframePayment);
		formthreeDSecure.threeDSubmit();
		closeThePopUp("no");
	}
	
	/**
	 * This method is used to checkout the SB SIMO new customer order.
	 * 
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void checkOutSBSIMONewCustomer(String postCode, final String customerType, final Customer customerObj,
			final BillingDetails bdObj, final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedSBSoleTraderDetails(postCode, customerObj);

		if (null != existingCustomer.checkGlobalMsgAndContinue())
		{
			personalDetails.continueToNext();
		}

		billingDetails.proceedBillingDetails(bdObj);
		termsAndConditions.agreeSBSoleTraderTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		waiter.waitForLoad();
		waiter.switchtoframe(threeDSecureiframePayment);
		formthreeDSecure.threeDSubmit();
		closeThePopUp("no");
	}

	/**
	 * This method is used to checkout the payg SIMO new customer order.
	 * 
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void checkOutSIMOPaygCustomer(final String customerType, final Customer customerObj,
			final BillingDetails bdObj, final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedSIMOPaygPersonalDetails(customerObj);
		termsAndConditions.agreeSIMOTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		waiter.switchtoframe(threeDSecureiframePayment);
		formthreeDSecure.threeDSubmit();
		closeThePopUp("no");
	}

	
	public void checkOutSBNewCustomer(String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedSBSoleTraderDetails(postCode, customerObj);

		if (null != existingCustomer.checkGlobalMsgAndContinue())
		{
			personalDetails.continueToNext();
		}
		billingDetails.proceedBillingDetails(bdObj);
		termsAndConditions.agreeSBTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		waiter.switchtoframe(threeDSecureiframePayment);
		formthreeDSecure.threeDSubmit();
		closeThePopUp("no");
	}
	
	public void checkOutSB(String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		existingCustomer.checkExistingCustomer(customerType);
		personalDetails.proceedSBSoleTraderDetails(postCode, customerObj);
		if (null != existingCustomer.checkGlobalMsgAndContinue())
		{
			personalDetails.continueToNext();
		}
		billingDetails.proceedBillingDetails(bdObj);
		termsAndConditions.agreeSBTerms();
		waiter.switchtoframe(iframePayment);
		paymentDetails.continueToNext(pdObj);
		closeThePopUp("no");
	}
	

	/**
	 * For closeThePopUp
	 */
	public void closeThePopUp(final String yesOrNo) {
		waiter.waitForLoad();
		browser.switchTo().activeElement();
		popUp.selectBtn(yesOrNo);
		
		/*String myWindowHandle = browser.getWindowHandle();
		if (null != myWindowHandle) {
			browser.switchTo().window(myWindowHandle);
			waiter.elementVisible(popUp);
			popUp.selectBtn(yesOrNo);
		}*/
	}

}
