package uk.ee.framework.pages.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import uk.ee.framework.business_objects.dao.billing_details.BillingDetails;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.elements.sections.shop.ConfirmationPopUp;
import uk.ee.framework.elements.sections.shop.UpgradeBillingAddress;
import uk.ee.framework.elements.sections.shop.UpgradeContactDetails;
import uk.ee.framework.elements.sections.shop.UpgradeDeliveryOptions;
import uk.ee.framework.elements.sections.shop.UpgradeDirectDebit;
import uk.ee.framework.elements.sections.shop.UpgradeTermsAndConditions;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 07/11/2016 Modified by prabhu_s on
 * 07/13/16. This is a upgrade checkout flow which is common for all the upgrade
 * scenarios.
 * 
 */
@Component
@Scope("prototype")
public class UpgradeCheckout extends BasePage {

	@FindBy(xpath = "//div[h3[text()='Your contact details']]")
	UpgradeContactDetails upgradeContactDetails;

	@FindBy(xpath = "//div[h3[text()='Your billing address']]")
	UpgradeBillingAddress upgradeBillingAddress;

	@FindBy(xpath = "//*[@id='deliveryModule']")
	UpgradeDeliveryOptions upgradeDeliveryOptions;

	@FindBy(xpath = "//div[h3[text()='Direct Debit']]")
	UpgradeDirectDebit upgradeDirectDebit;

	@FindBy(xpath = "//*[@id='CQ5UpgradeCheckout_m25_TermsAndConditions_POID']")
	UpgradeTermsAndConditions upgradeTermsAndConditions;

	@FindBy(xpath = "(//button[@class='paySecurelyButton validation-required cta-spinner'])[1]")
	WebElement proceedToPayment;

	@FindBy(css = "iframe.tccIFrame")
	WebElement iframePayment;

	@FindBy(css = "form#payment")
	PaymentDetails paymentDetails;

	@FindBy(css = "iframe.secure3DIFrame")
	WebElement threeDSecureiframePayment;

	@Autowired
	ThreeDSecure formthreeDSecure;

	@FindBy(xpath = "//*[@id='oo_invitation_prompt']")
	ConfirmationPopUp popUp;

	@FindBy(css="div.white.panel.pinValidation")
	WebElement pinSec;
	
	/**
	 * This method is used to upgrade the paym phones.
	 * 
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void upgradePaymPhones(final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {

		if (pinSec.isDisplayed()) {
			Assert.fail("Please turn off pic in AEM");
		} else {
			upgradeContactDetails.fillContactDetails(customerObj);
			upgradeBillingAddress.fillBillingAddressDetails(customerObj);
			// upgradeDeliveryOptions
			upgradeDirectDebit.fillDebitCardDetails(bdObj);
			upgradeTermsAndConditions.agreeTerms();
			proceedToPayment.click();
			/*
			 * waiter.switchtoframe(iframePayment);
			 * paymentDetails.continueToNext(pdObj);
			 * waiter.switchtoframe(threeDSecureiframePayment);
			 * formthreeDSecure.threeDSubmit();
			 */

			closeThePopUp("no");
		}
	}

	/**
	 * For closeThePopUp
	 */
	public void closeThePopUp(final String yesOrNo) {
		String myWindowHandle = browser.getWindowHandle();
		if (null != myWindowHandle) {
			browser.switchTo().window(myWindowHandle);
			popUp.selectBtn(yesOrNo);
		}
	}
}
