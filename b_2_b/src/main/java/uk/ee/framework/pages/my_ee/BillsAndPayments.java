package uk.ee.framework.pages.my_ee;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import uk.ee.framework.business_objects.dao.Payment;
import uk.ee.framework.business_objects.dao.direct_debit.DirectDebit;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.elements.sections.my_ee.BillsPaymentsTab;
import uk.ee.framework.elements.sections.my_ee.DirectDebitTab;
import uk.ee.framework.elements.sections.my_ee.LastBill_BillsAndPayments;
import uk.ee.framework.elements.sections.my_ee.MakePaymentTab;
import uk.ee.framework.pages.BasePage;
import uk.ee.framework.utils.ConfirmationPopUp;

/**
 * updated by Prabhu S on 5/10/16.
 * 
 * Modified by Syamphaneendra kalluri on 08/04/16.
 */
@Component
@Scope("prototype")
public class BillsAndPayments extends BasePage {

	@FindBy(css = "section#viewtabs")
	BillsPaymentsTab billsPaymentsTab;

	@FindBy(css = "a[href*='/direct-debit/#viewtabs']")
	DirectDebitTab ddTab;

//	@FindBy(xpath = "//a[contains(text(),'Set up Direct Debit')]")
//	DirectDebitTab ddLink;
	
	@FindBy(xpath = "//li/a[@id='btn-2']")
	MakePaymentTab makePaymentTab;
	
	@FindBy(css = "div.col.span-8.balance-container")
	LastBill_BillsAndPayments billsPageLastBill;

	@FindBy(id = "btn-1")
	 Link invoiceTab;
	
	@FindBy(css = "div.your-latest-bill-info")
	public TextInput latestBillInfo;
	
	@FindBy(xpath = "//td/b[contains(text(),'Brought forward')]")
	public TextInput broughtForward;
	
	@FindBy(xpath = "//span[contains(text(),'Your monthly plan charges')]")
	public TextInput monthlyCharges;
	
	@FindBy(xpath = "//span[contains(text(),'Extra charges outside your plan')]")
	public TextInput extraCharges;
	
	@FindBy(xpath = "//td/b[contains(text(),'Subtotal')]")
	public TextInput subTotal;
	
	@FindBy(xpath = "//span[contains(text(),'VAT')]")
	public TextInput vat;
	
	@FindBy(xpath = "//td/b[contains(text(),'Total')]")
	public TextInput total;

	@FindBy(css = "span.billing-info-right")
	List<WebElement> billingInfo;

	@FindBy(xpath = "//*[@id='oo_invitation_prompt']")
	ConfirmationPopUp popUp;

	@FindBy(css = "div.mod-notification-pane")
	WebElement notificationArea;
	 
	@FindBy(xpath ="//td[@class='price']")
	List<WebElement> price;
	
	 public String viewBillInfo() {
			invoiceTab.click();	
			Assert.assertTrue(latestBillInfo.isDisplayed());
			Assert.assertTrue(broughtForward.isDisplayed());
			Assert.assertTrue(monthlyCharges.isDisplayed());
			Assert.assertTrue(extraCharges.isDisplayed());
			Assert.assertTrue(subTotal.isDisplayed());
			Assert.assertTrue(total.isDisplayed());
//			Assert.assertTrue(price.get(price.size()-1).getText().contains("�"));
			return price.get(price.size()-1).getText();			
		}
	
	/*public void makePayment(Payment payment) {
		billsPaymentsTab.makePayment(payment);
	}*/
	
	/**
	 * @param payment
	 * @param pdObj
	 * @param card
	 */
	public void makeExtUserPayBillWithExtCC(final Payment payment, final PaymentDetails pdObj, final String card) {
		billsPaymentsTab.makePaymentOrDebitCardTab(payment, pdObj, card);
		try {
			closeThePopUp("no", popUp);
		} catch (NoSuchElementException exception) {
			System.out.println("Result: " + notificationArea.getText());
			Assert.assertTrue(notificationArea.getText().contains("Payment successful"));
		}
		System.out.println("Result: " + notificationArea.getText());
		Assert.assertTrue(notificationArea.getText().contains("Payment successful"));
	}

	public boolean setupDD(DirectDebit debit) {
		if (!billsPaymentsTab.billPaidStatus()) {
			Assert.assertTrue(false, "Outstanding balance cannot Set DD");
			return false;
		}

		try {
			if (ddTab.isDisplayed()) {
				Assert.assertTrue(false, "DD Already Set");
				return false;
			}
		}

		catch (NoSuchElementException e) {
			billsPageLastBill.clickDDLink();
			boolean ddStatus = makePaymentTab.setupDD(debit);
			//boolean ddStatus = ddLink.setupDD(debit);
			return ddStatus;
		}
		return false;

	}
	
	/**
	 * @param debit
	 */
	public void editAndSaveDirectDebit(DirectDebit debit)
	{
		if (billsPaymentsTab.isEditDebitCardTab())
		{
			if (makePaymentTab.setupDD(debit))
			{
				WebElement notificationText = browser.findElement(
						By.cssSelector("span[class='h4 mod-notification-pane__title-text']"));
				System.out.println("Result: " + notificationText.getText());
				Assert.assertTrue(notificationText.getText().contains("Your Direct Debit details has been successfully updated."));
			}
		}
	}
	
}
