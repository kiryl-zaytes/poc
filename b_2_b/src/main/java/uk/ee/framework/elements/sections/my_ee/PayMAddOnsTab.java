package uk.ee.framework.elements.sections.my_ee;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class PayMAddOnsTab extends CustomHtmlElement{

	  @FindBy(xpath = "//button[contains(text(),'CONFIRM')]")
	  List<WebElement> confirm;
	  
	  @FindBy(xpath = "//a[@class='button button--buy-addon-action']")
	  List<WebElement> learnMore;
	  
	  @FindBy(xpath = "//a[contains(text(),'Buy now')]")
	  List<WebElement> buyNow;
	  
	  @FindBy(css ="div.panel.mod-notification-pane__title")
	  TextBlock successMessage;
		
		@FindBy(xpath ="//a[contains(text(),'Remove add-on')]")
		Button removeAddOn;

		@FindBy(xpath ="//*[contains(text(),'CONFIRM')]")
		Button confirmRemove;
	  
	public String buyAddon(){

		Random randomGenerator = new Random();
		int randomIndex = randomGenerator.nextInt(learnMore.size()) + 1;
		
		learnMore.get(1).click();
//		buyNow.click();
		
		loop(buyNow);
		loop(confirm);
		System.out.println("done");
		
		return "Success";
		}
	
	public String loop(List<WebElement> ele) {
		int n = ele.size();
		for (int i=0; i<= n ; i++){
		if (ele.get(i).isDisplayed()){
			ele.get(i).click();		
			break;
//			return successMessage.getText();
			}
		}
		return "Not Purchased";
	}

	public void selectRemoveAddon() {
		removeAddOn.click();
		confirmRemove.click();		
	}
}
