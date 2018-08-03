package uk.ee.framework.pages.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.pages.BasePage;

/**
 * Created by prabhu_S on 7/07/16.
 */

@Component
@Scope("prototype")
public class CheckStoreStock extends BasePage {
	
	@FindBy(css="input#postcode.search-stores")
	TextInput postcode;
	
	@FindBy(id="searchNow")
	Button searchNow;
	
	@FindBy(css="div#stockLevelsContainer")
	WebElement stockBlock;
	
	@FindBy(css="tbody#stockLevels")
	TextBlock stockLevels;
	
	@FindBy(css="td.stock-level.out-of-stock")
	TextBlock stockNumb;
		
	public void stockLevels() {
		postcode.sendKeys("LS98AY");
		searchNow.click();
		waiter.elementVisible(stockBlock);
		System.out.println(stockLevels.getText());
		System.out.println(stockNumb.getText());
		Assert.assertNotNull(stockNumb);
	}

}