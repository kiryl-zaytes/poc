package uk.ee.framework.elements.sections.my_ee;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class RegisteredCardsTable extends CustomHtmlElement{

	@FindBy(xpath = "//a[contains(text(),'Remove card')]")
	List<WebElement> removeCardBtn;
	
	@FindBy(css = "button.pull-left")
	Button confirmRemoveCardBtn;	
	
	public void removeCard() {
		Random randomGenerator = new Random();
		int randomIndex = randomGenerator.nextInt(removeCardBtn.size());
		System.out.println(randomIndex);
		removeCardBtn.get(randomIndex).click();
		confirmRemoveCardBtn.click();		
	}
}

