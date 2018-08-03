package uk.ee.framework.elements.sections.my_ee;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import uk.ee.framework.business_objects.dao.credit_card.CreditCard;
import uk.ee.framework.elements.common.Select;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class TopUpDetails extends CustomHtmlElement {
	@FindBy(xpath = "//button[@id='manageCards']")
	Button manageCardsBtn;

	@FindBy(xpath = "//a[contains(text(),'Remove card')]")
	List<WebElement> removeCardBtn;

	// @FindBy(xpath = "//a[contains(text(),'Remove card')]")
	@FindBy(css = "button.pull-left")
	Button confirmRemoveCardBtn;

	@FindBy(css = "div.panel.mod-notification-pane__title")
	TextBlock notificationArea;

	/*New card*/
	@FindBy(id ="firstName")
	TextInput firstName;
	@FindBy(id ="lastName")
	TextInput lastName;
	@FindBy(css="input#cardNumber")
	TextInput cardNumber;
	@FindBy(css="select#expirationMonth")
	Select expirationMonth;
	@FindBy(css="select#expirationYear")
	Select expirationYear;
	@FindBy(css="input#cvv")
	TextInput cvv;
	@FindBy(css="input#postCode")
	TextInput postCode;
	@FindBy(css="button#findAddress")
	Button findAddress;
	@FindBy(css="select#addressListBox")
	Select addressListBox;
	@FindBy(css="input#submitButton")
	Button submitButton;
	
	@FindBy(css="button#newCard")
	Button newCard;
	
	
	public boolean manageCards() {
		try {
			if (manageCardsBtn.isDisplayed()) {
				manageCardsBtn.click();
				return true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("No Registered cards to remove!");
			return false;
		}
		return false;
	}

	public void topUpNewCard(CreditCard creditCard) {
		if (newCard.exists()) {
			newCard.click();
			enterNewCardDetails(creditCard);
		} else {
			enterNewCardDetails(creditCard);
		}
	}

	private void enterNewCardDetails(CreditCard creditCard){
		firstName.sendKeys(creditCard.getFirstName());
		lastName.sendKeys(creditCard.getLastName());
		cardNumber.sendKeys(creditCard.getCardNumber());
		expirationMonth.selectByValue(creditCard.getExpiryMonth());
		expirationYear.selectByValue(creditCard.getExpiryYear());
		cvv.sendKeys(creditCard.getSecurityCode());
		postCode.sendKeys(creditCard.getPostCode());
		findAddress.click();
		addressListBox.selectByValue("2");
		submitButton.click();
	}
	
}
