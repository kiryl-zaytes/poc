package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import uk.ee.framework.business_objects.dao.credit_card.CreditCard;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Select;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.elements.sections.my_ee.RegisteredCardsTable;
import uk.ee.framework.elements.sections.my_ee.TopUpCompleteTab;
import uk.ee.framework.elements.sections.my_ee.TopUpConfirmTab;
import uk.ee.framework.elements.sections.my_ee.TopUpDetails;
import uk.ee.framework.pages.BasePage;
import uk.ee.framework.utils.ConfirmationPopUp;

/**
 * Updated by anuj_dasari on 5/30/16.
 */
@Component
@Scope("prototype")
public class TopUp extends BasePage {

	@FindBy(css = "div.panel.clearfix")
	TopUpDetails topUpDetails;

	@FindBy(xpath = "//fieldset[@id='fieldset-remove-card']")
	// @FindBy(xpath = "//main[@id='main']")
	RegisteredCardsTable regCardDetails;
	
	@FindBy(css="input#cvn_txt_field-1")
	TextInput securityCode;
	
	@FindBy(css="input#submitButton")
	WebElement okIdLikeToPay;
	
	@FindBy(css = "section.module.margin-top-1em")
	TopUpConfirmTab topUpNewCardConfirmTab;
	
	@FindBy(css = "section.module.margin-top-1em")
	TopUpCompleteTab topUpCompleteTab;
	
	@FindBy(xpath = "//*[@id='oo_invitation_prompt']")
	ConfirmationPopUp popUp;
	
	@FindBy(css = "span.h4.mod-notification-pane__title-text")
	WebElement notificationArea; 
    	
	
	public void manageCards() {
		boolean manageCardsExist = topUpDetails.manageCards();

		if (manageCardsExist) {
			regCardDetails.removeCard();
			try {
				closeThePopUp("no", popUp);
				System.out.println("Status: " + notificationArea.getText());
				Assert.assertTrue(notificationArea.getText().contains("The selected card has been removed from My EE"));
			} catch (NoSuchElementException exception) {
				System.out.println("Status: " + notificationArea.getText());
				Assert.assertTrue(notificationArea.getText().contains("The selected card has been removed from My EE"));
			}
		} else {
			System.out.println("No Cards to Remove");
		}
	}
	
	public void topUpExistingCard() {
		try{
		if (securityCode.isDisplayed()) {
			securityCode.sendKeys("123");
			okIdLikeToPay.click();
			topUpCompleteTab.successTopUp();

		} 
		} catch (NoSuchElementException e){
			
			Assert.fail("No Registered Card, Please register one");			
		}
	}
	
	public void topUpNewCard(CreditCard creditCard) {
		topUpDetails.topUpNewCard(creditCard);
		topUpNewCardConfirmTab.topUpNewCardConfirm();
		topUpCompleteTab.successTopUp();
	}
	
}
