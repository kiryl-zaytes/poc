package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
/**
 * Created by anuj_dasari on 5/13/16.
 */

public class TopTasks extends CustomHtmlElement {
	
	@FindBy (xpath = "//a[contains(text(),'Top up and register card')]")
	WebElement topUpRegisterCard;
	
	@FindBy (xpath = "//a[contains(text(),'View packs')]")
	WebElement viewPacks;
	
	@FindBy (xpath = "//a[contains(text(),'View usage')]")
	WebElement viewUsage;
	
   	@FindBy (xpath = "//a[contains(text(),'top up history')]")
   	WebElement topUpHistory;
   
   
   	public void viewTopUpHistory(){
   		topUpHistory.click();
   	}
}
