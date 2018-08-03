package uk.ee.framework.elements.sections.my_ee;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 08/08/2016
 * 
 * This class represents the selenium version of the choose data pack section.
 * 
 */
public class ChoosePack extends CustomHtmlElement {

	@FindBy(xpath = "//button[contains(text(),'CHOOSE')]")
	List<WebElement> chooseBtns;

	/**
	 * This method is used to select the data pack and return the status.
	 * 
	 * @param choosePack
	 * @param choosePack
	 * 
	 * @return
	 */
	public String chooseDataPack() {
		Random randomGenerator = new Random();
		List<WebElement> packsGroup = webDriver.findElements(By.xpath("//*[@id='packs']/section/descendant::li"));
		System.out.println("packsGroup.size(): " + packsGroup.size());
		int randomIndex = randomGenerator.nextInt(packsGroup.size());
		System.out.println("randomIndex: " + randomIndex);
		packsGroup.get(randomIndex).click();
		System.out.println("chooseBtns.size(): " + chooseBtns.size());
		loop(chooseBtns);
		List<WebElement> confirmBtns = webDriver.findElements(By.xpath("//button[contains(text(),'Confirm')]"));
		System.out.println("confirmBtns.size(): " + confirmBtns.size());
		loop(confirmBtns);
		WebElement result = webDriver.findElement(By.cssSelector("span.h4.mod-notification-pane-title-text"));
		System.out.println("Status: " + result.getText());
		Assert.assertTrue(result.getText().trim().equals("pack purchased"));
		return result.getText();
	}

	/**
	 * @param ele
	 */
	public void loop(List<WebElement> ele) {
		int n = ele.size();
		for (int i = 0; i <= n; i++) {
			if (ele.get(i).isDisplayed()) {
				System.out.println("selected: " + i);
				ele.get(i).click();
				break;
			}
		}
	}
}
