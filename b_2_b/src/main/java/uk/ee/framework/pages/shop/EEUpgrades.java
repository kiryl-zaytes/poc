package uk.ee.framework.pages.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.pages.BasePage;
/**
 * Created by prabhu_s on 07/13/16.
 */
@Component
@Scope("prototype")
public class EEUpgrades extends BasePage{

	@FindBy(xpath="//a[text()='View all phones']")
	WebElement viewPhones;
	
	public void upgradePhones() {
		viewPhones.click();
	}
}
