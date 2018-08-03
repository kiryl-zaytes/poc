package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class LastBill_BillsAndPayments extends CustomHtmlElement {
	@FindBy(xpath = "//a[contains(text(),'Set up Direct Debit')]")
	public WebElement ddLink;
	
	public void clickDDLink(){
		ddLink.click();
		
	}

}
