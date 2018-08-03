package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by anuj_dasari on 5/12/16.
 */
public class CurrentUsage extends CustomHtmlElement {
	
	   	@FindBy (css = "a[href*=usage-since-latest-bill]")
	    Button seeUsage;
	   
	   	@FindBy (css = "div.col.usage-charges")
	   	TextBlock extraCharges;
	   	
	   	 public void viewAllowances(){
	   		 seeUsage.click();
	    }
}