package uk.ee.framework.elements.sections.my_ee;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class PayGPacksTab extends CustomHtmlElement{
	@FindBy(id="change-subscription-opener")
	Button change;
	
	@FindBy(css= "button.no-margin-right nowrap toggle-elements pull-right")
	List<WebElement> buyPack;
	
	@FindBy(id = "confirmSelectPack")
	List<WebElement> confirm;
	
	public void changePack(){
		try{
		if (change.isDisplayed()){
			change.click();
			purchasePack();
		} }catch (NoSuchElementException e){
			purchasePack();
		}
	}

	public String purchasePack(){
		Random randomGenerator = new Random();
		int randomIndex = randomGenerator.nextInt(buyPack.size()) + 1;
		buyPack.get(randomIndex).click();
//		int n = confirm.size();
//		for (int i=0; i<= n ; i++){
//		if (confirm.get(i).isDisplayed()){
//			confirm.get(i).click();
//			return "Success";
//			}
//		}
		return "Success";
	}
	
}
