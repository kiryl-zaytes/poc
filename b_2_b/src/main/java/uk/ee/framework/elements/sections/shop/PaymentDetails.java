package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * 
 * This class represents the selenium version of the Payment Details section.
 * 
 */
public class PaymentDetails extends CustomHtmlElement {

	@FindBy(xpath = "//*[@id='cardType']")
	Select cardType;

	@FindBy(xpath = "//*[@id='nameOnCard']")
	TextInput nameOnCard;

	@FindBy(xpath = "//*[@id='creditCardNumber']")
	TextInput cardNumber;

	@FindBy(xpath = "//*[@id='cardValidFromMonth']")
	Select startDateMonth;

	@FindBy(xpath = "//*[@id='cardValidFromYear']")
	Select startDateYear;

	@FindBy(xpath = "//*[@id='expirationMonth']")
	Select expiryDateMonth;

	@FindBy(xpath = "//*[@id='expirationYear']")
	Select expiryDateYear;

	@FindBy(xpath = "//*[@id='issueNumber']")
	TextInput issueNumber;

	@FindBy(xpath = "//label[@for='cardSecurityCode']")
	TextInput cardSecurityCode;

	/*
	 * @FindBy(xpath = "//*[@id=cardType]") Select cardType;
	 * 
	 * @FindBy(id = "nameOnCard") TextInput nameOnCard;
	 * 
	 * @FindBy(id = "creditCardNumber") TextInput cardNumber;
	 * 
	 * @FindBy(css = "cardValidFromMonth") Select startDateMonth;
	 * 
	 * @FindBy(css = "cardValidFromYear") Select startDateYear;
	 * 
	 * @FindBy(css = "expirationMonth") Select expiryDateMonth;
	 * 
	 * @FindBy(css = "expirationYear") Select expiryDateYear;
	 * 
	 * @FindBy(id = "issueNumber") TextInput issueNumber;
	 * 
	 * @FindBy(id = "cardSecurityCode") TextInput cardSecurityCode;
	 */

	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Continue')]")
	Button continueBtn;

	/**
	 * @param pdObj
	 */
	public void continueToNext(final uk.ee.framework.business_objects.dao.payment_details.PaymentDetails pdObj) {
		setPaymentDetails(pdObj);
		continueBtn.click();
	}

	/**
	 * @param pdObj
	 */
	private void setPaymentDetails(final uk.ee.framework.business_objects.dao.payment_details.PaymentDetails pdObj) {

		nameOnCard.sendKeys(pdObj.getNameOnCard());
		cardNumber.sendKeys(pdObj.getCardNumber());
		cardType.selectByValue(pdObj.getCardType());
		// startDateMonth.selectByValue(pdObj.getStartDateMonth());
		// startDateYear.selectByValue(pdObj.getStartDateYear());
		expiryDateMonth.selectByValue(pdObj.getExpiryDateMonth());
		expiryDateYear.selectByValue(pdObj.getExpiryDateYear());
		if (issueNumber.isEnabled()) {
			issueNumber.sendKeys(pdObj.getIssueNumber());
		}
		cardSecurityCode.sendKeys(pdObj.getCardSecurityCode());
//		continueBtn.click();
	}
}
