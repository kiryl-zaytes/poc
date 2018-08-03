package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 07/07/2016
 * 
 * This class represents the selenium version of the SB Tablets Home screen.
 * 
 */
@Component
@Scope("prototype")
public class SBTabletsHomeScreen extends BasePage {

	@FindBy(xpath = "//*[@id='main']/div[3]/div[3]/section/div/article/div[2]/div/div/p/a")
	Button sbTabletsLink;

	public void selectTablets() {
		sbTabletsLink.click();
	}

}
