package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * 
 * This class represents the selenium version of the BestSellingPlan section.
 * 
 */
public class BestSellingPlan extends CustomHtmlElement {

	@FindBy(css = "input[type='submit']")
	Button chooseThisPlan;

	/**
	 * 
	 */
	public void choosePlan() {
		chooseThisPlan.click();
	}

	/**
	 * @param name
	 */
	public void choosePlan(String name) {

	}
}
