package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Updated by anuj_dasari on 5/16/16.
 */

public class CurrentCredit extends CustomHtmlElement {
	
	@FindBy(css = "h3.mod-current-credit__title")
	WebElement creditTileHeader;
	
	@FindBy(css = "span.h2.mod-current-credit__value")
	WebElement currentCreditAmount;
	
	@FindBy(xpath = "//input[@id='topupBtn']")
	WebElement topUpBtn;
	
	
    public String viewCurrentCreditDetails(){
//    	Assert.assertTrue(currentCreditAmount.getText().contains("�"));
    	
        String currentCredit = currentCreditAmount.getText();
        return currentCredit;
    } 
    
    public void clickTopUpBtn() {
    	topUpBtn.click();
    }
}