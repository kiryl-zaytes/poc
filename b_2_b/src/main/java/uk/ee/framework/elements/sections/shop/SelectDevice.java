package uk.ee.framework.elements.sections.shop;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by prabhu_S on 7/7/16.
 */

public class SelectDevice extends CustomHtmlElement {

	@FindBy(xpath="//label[contains(text(),'Compare stock for this item')]")
	List<WebElement> compareCheckBox;
	
	@FindBy(css="input#compareStock.pull-right")
	WebElement compareStock;
	
	public void selectDeviceToCompare(){
//		Random randomGenerator = new Random();
//		int randomIndex = randomGenerator.nextInt(compareCheckBox.size())+1;
		compareCheckBox.get(1).click();
		waiter.elementIsClickable(compareStock);
		compareStock.click();
	}
}