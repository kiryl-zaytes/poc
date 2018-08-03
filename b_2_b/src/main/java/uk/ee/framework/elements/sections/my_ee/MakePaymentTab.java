package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uk.ee.framework.business_objects.dao.direct_debit.DirectDebit;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class MakePaymentTab extends CustomHtmlElement {
	//@FindBy (id = "bankSortCodee1")	
	@FindBy (xpath = "//input[@id='bankSortCodee1']")
	TextInput bankSortCodee1;
	
	//@FindBy (id = "bankSortCodee2")	
	@FindBy (xpath = "//input[@id='bankSortCodee2']")
	TextInput bankSortCodee2;
	
	//@FindBy (id = "bankSortCodee3")	
	@FindBy (xpath = "//input[@id='bankSortCodee3']")
	TextInput bankSortCodee3;
	
	@FindBy (xpath = "//input[@id='accountNumberr']")	
	public WebElement accountNumber;
	
	@FindBy (xpath = "//input[@id='accountName']")	
	public WebElement accountName;
	
	//@FindBy (id = "save-details-btn")	
	@FindBy (xpath = "//button[@id='save-details-btn']")
	Button saveDetails;
	
	@FindBy (xpath = "//div[@class='col span-9 no-padding-top']")	
	TextBlock ddInfo;
	
	@FindBy (css="span.h4.mod-notification-pane__title-text")	
	TextBlock successMsg;
	
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Confirm')]")
	Button confirmDDButton;
	
	public boolean setupDD(DirectDebit directdebit){
		bankSortCodee1.sendKeys(directdebit.getSortCode1());
		bankSortCodee2.sendKeys(directdebit.getSortCode2());
		bankSortCodee3.sendKeys(directdebit.getSortCode3());
		accountNumber.sendKeys(directdebit.getAccountNumber());
		accountName.sendKeys(directdebit.getAccountName());
		saveDetails.click();
		if (ddInfo.getText().contains(directdebit.getAccountNumber())) {
			confirmDDButton.click();
			Assert.assertTrue(successMsg.getText().contains("Success"));
			return true;
		}
		else {
			return false;
		}
		
	}

}
