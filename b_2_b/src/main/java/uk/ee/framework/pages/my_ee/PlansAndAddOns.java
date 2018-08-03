package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.sections.my_ee.PayGAddOnsTab;
import uk.ee.framework.elements.sections.my_ee.PayMAddOnsTab;
import uk.ee.framework.pages.BasePage;


@Component
@Scope("prototype")
public class PlansAndAddOns extends BasePage{

	@FindBy (xpath = "//*[@id='btn-2']")
	PayMAddOnsTab paymAddOnsTab;
	
	 @FindBy(css ="span.h4.mod-notification-pane__title-text")
	  TextBlock successMessageAddOnPurchase;
	
	public void selectRemoveAddons(){
		paymAddOnsTab.click();
		paymAddOnsTab.selectRemoveAddon();
		Assert.assertTrue(successMessageAddOnPurchase.getText().contains("successfully"));
	}
	
	public void selectBuyAddons(){
		paymAddOnsTab.click();
		paymAddOnsTab.buyAddon();
		Assert.assertTrue(successMessageAddOnPurchase.getText().contains("successfully"));
	}
}
