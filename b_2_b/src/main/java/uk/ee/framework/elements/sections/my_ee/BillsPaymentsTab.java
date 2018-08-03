package uk.ee.framework.elements.sections.my_ee;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Radio;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.business_objects.dao.Payment;
import uk.ee.framework.business_objects.dao.direct_debit.DirectDebit;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by kiryl_zayets on 5/8/16.
 * 
 * Modified by Syamphaneendra kalluri on 08/02/16.
 */
public class BillsPaymentsTab extends CustomHtmlElement {

	@FindBy(css = "#btn-1")
	Button bills;

	@FindBy(css = "#btn-2")
	WebElement makePaymentOrDebitCardTab;

	@FindBy(css = "#btn-3")
	Button paymentHistory;

	@FindBy(css = "input#paymentType")
	Radio paymentType;

	@FindBy(css = "#fullPaymentAmt+label")
	Button fullAmount;

	@FindBy(css = "#InputTopUpAmount+label")
	Button partialAmount;

	@FindBy(css = "#topUpAmount")
	TextInput amount;

	@FindBy(css = "input.card-cvn")
	TextInput cvn;

	@FindBy(css = "#use_new_card")
	Button newCard;

	@FindBy(css = "#manage_cards")
	Button removeCreditCard;

	@FindBy(css = "#make_a_payment")
	Button confirmPayment;

	@FindBy(css = "#paymentConfirmationId")
	Button confirmation;

	@FindBy(css = "form#payment")
	AddCreditCard addCreditCard;

	@FindBy(xpath = "//p[contains(text(),'due')]")
	WebElement billPaymentStatus;

	@FindBy(css = "iframe.module-iframe")
	WebElement threeDSecureiframePayment;

	@FindBy(xpath = "//input[@type='password']")
	TextInput threeDPassword;

	@FindBy(xpath = "//input[@name='UsernamePasswordEntry']")
	Button threeDSubmit;

	@FindBy(xpath = "//label[@class='card-name']")
	List<WebElement> radioBtns;
	
	@FindBy(xpath = "//a[contains(text(),'Make a payment')]")
	WebElement makePaymentLink;
	
	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	WebElement editBtn;

	private String selectedCard = null;	

	/**
	 * @param payment
	 * @param pdObj
	 * @param card
	 */
	public void makePaymentOrDebitCardTab(final Payment payment, final PaymentDetails pdObj, final String... card) {
		System.out.println("makePayment.getText(): " + makePaymentOrDebitCardTab.getText());
		makePaymentOrDebitCardTab.click();
		if (makePaymentOrDebitCardTab.getText().contains("Direct Debit")) 
		{
			directDebitTabFunctionality(payment, pdObj);
		} else 
		{
			makePaymentTabFunctionality(payment, card);
		}
	}

	/**
	 * This method is used to return the WebElement correspond to selected radio
	 * button.
	 * 
	 * @param card
	 * @return
	 */
	private WebElement getSelectedRadioElement(String[] card) {
		selectedCard = card[0];
		System.out.println("card1: " + selectedCard);
		if (null != radioBtns && radioBtns.size() > 0) {
			for (WebElement element : radioBtns) {
				System.out.println("element.getText(): " + element.getText());
				System.out.println("element.getAttribute(for): " + element.getAttribute("for"));
				if (null != element.getText() && element.getAttribute("for").contains(selectedCard)) {
					return element;
				}

			}
		}
		return null;
	}
	
	
	/**
	 * This method is represents the make payment tab functionality.
	 * 
	 * @param payment
	 * @param card
	 */
	private void makePaymentTabFunctionality(final Payment payment, final String... card)
	{		
		if (null != card && card.length > 0) 
		{
			WebElement selectedRadioBtn = getSelectedRadioElement(card);
			selectedRadioBtn.click();
		}
		switch (payment.getPayment_choice()) {
		case FULL:
			fullAmount.click();
			break;
		case ANOTHER:
			partialAmount.click();
			amount.sendKeys(payment.getAmount());
			break;
		default:
			fullAmount.click();
		}
		switch (payment.getCreditcard_choice()) 
		{
		case EXISTING:
			// cvn.sendKeys(payment.getCreditCard().getSecurityCode());
			webDriver.findElement(By.xpath("//*[contains(@id,'cvn_txt_field-" + selectedCard + "')]"))
					.sendKeys(payment.getCreditCard().getSecurityCode());
			break;
		case ADD_NEW:
			newCard.click();
			addCreditCard.addCreditCard(payment.getCreditCard());
			break;
		case REMOVE_AND_ADD:
			removeCreditCard.click();
			addCreditCard.addCreditCard(payment.getCreditCard());
			break;
		}
		confirmPayment.click();
		confirmation.click();
		waiter.switchtoframe(threeDSecureiframePayment);
		webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
		webDriver.findElement(By.xpath("//input[@name='UsernamePasswordEntry']")).click();
	}
	
	/**
	 * 
	 * This method is represents the direct debit tab functionality.
	 * 
	 * @param payment
	 * @param pdObj
	 */
	private void directDebitTabFunctionality(Payment payment,
			final uk.ee.framework.business_objects.dao.payment_details.PaymentDetails pdObj) {
		makePaymentLink.click();
		amount.sendKeys(payment.getAmount());
		newCard.click();
		waiter.switchtoframe(threeDSecureiframePayment);
		//iframe credit card details.
		new Select(webDriver.findElement(By.xpath("//*[@id='cardType']"))).selectByValue(pdObj.getCardType());
		webDriver.findElement(By.xpath("//*[@id='nameOnCard']")).sendKeys(pdObj.getNameOnCard());
		webDriver.findElement(By.xpath("//*[@id='creditCardNumber']")).sendKeys(pdObj.getCardNumber());		
		/*new Select(webDriver.findElement(By.xpath("//*[@id='cardValidFromMonth']"))).selectByValue(payment.getCreditCard().getAccountName());
		new Select(webDriver.findElement(By.xpath("//*[@id='cardValidFromYear']"))).selectByValue(payment.getCreditCard().getAccountName());*/		
		new Select(webDriver.findElement(By.xpath("//*[@id='expirationMonth']"))).selectByValue(pdObj.getExpiryDateMonth());
		new Select(webDriver.findElement(By.xpath("//*[@id='expirationYear']"))).selectByValue(pdObj.getExpiryDateYear());	
		if (webDriver.findElement(By.xpath("//*[@id='issueNumber']")).isEnabled())
		{
			webDriver.findElement(By.xpath("//*[@id='issueNumber']")).sendKeys(pdObj.getIssueNumber());
		}
		webDriver.findElement(By.xpath("//*[@id='cardSecurityCode']")).sendKeys(pdObj.getCardSecurityCode());	
		webDriver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Continue')]")).click();
		confirmation.click();
		//3D secure details
		waiter.switchtoframe(threeDSecureiframePayment);
		webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
		webDriver.findElement(By.xpath("//input[@name='UsernamePasswordEntry']")).click();
	}

	public boolean billPaidStatus() {
		try {
			if (billPaymentStatus.getText().contains("payment >")) {
				return false;
			}
		}

		catch (NoSuchElementException e) {
			return true;
		}
		return false;

	}
	
	/**
	 * @param payment
	 * @param pdObj
	 * @param card
	 */
	public boolean isEditDebitCardTab() {
		try {
			System.out.println("makePayment.getText(): " + makePaymentOrDebitCardTab.getText());
			makePaymentOrDebitCardTab.click();
			if (makePaymentOrDebitCardTab.getText().contains("Direct Debit")) {
				editBtn.click();
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException exception) {
			return false;
		}
	}
}
