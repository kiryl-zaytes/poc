package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * 
 * This class represents the selenium version of the Other SellingPlans section.
 * 
 */

@FindBy(css = "form#command")
public class OtherSellingPlans extends CustomHtmlElement {

	@FindBy(xpath = "//button[@type='submit' and contains(text(),'CHOOSE')]")
	Button choose;

	/**
	 * 
	 */
	public void choosePlan() {
		choose.click();
	}

	/**
	 * @param name
	 */
	public void choosePlan(String name) {

	}
}
