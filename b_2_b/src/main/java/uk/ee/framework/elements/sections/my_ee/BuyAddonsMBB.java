package uk.ee.framework.elements.sections.my_ee;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by prabhu_s on 08/02/16.
 * 
 */
public class BuyAddonsMBB extends CustomHtmlElement{
	
	@FindBy(css="h3.mod-current-credit__title")
	TextBlock buyAddons;
	
	@FindBy(css="#main > form > section > div > div > div:nth-child(2) > div > ol > li:nth-child(2)")
	TextBlock addonLink;
	
	public void validateBuyAddonSection(){
		Assert.assertTrue(buyAddons.getText().contains("Buy add-ons"));
		Assert.assertTrue(addonLink.getText().contains("Go to"));
	}

}
