package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.sections.my_ee.ChoosePack;
import uk.ee.framework.elements.sections.my_ee.PayGAddOnsTab;
import uk.ee.framework.elements.sections.my_ee.PayGAllowanceSectionDashboard;
import uk.ee.framework.elements.sections.my_ee.PayGPacksTab;
import uk.ee.framework.pages.BasePage;

/**
 * Created by anuj_dasari on 5/31/16.
 * 
 * Modified by Syamphaneendra kalluri on 08/08/16.
 * Modified by Prabhu on 08/03/16.
 */
@Component
@Scope("prototype")
public class PacksAndAddons extends BasePage {

	@FindBy(css = "div.tabs.tabs__tabs-decoration-container>ul")
	PayGAllowanceSectionDashboard payGAllowanceTabs;

	@FindBy(css = "a#btn-1")
	PayGPacksTab payGPacksTab;

	@FindBy(xpath = "//a[text()='Pack']")
	ChoosePack choosePackTab;

	@FindBy(xpath = "//a[contains(text(),'Add-ons')]")
	PayGAddOnsTab addOnsTab;

	@FindBy(css = "section.expandable.accordion.module.theme-container.get-add-ons.ee-form")
	PayGAddOnsTab addonsSection;

	@FindBy(css = "span.h4.mod-notification-pane-title-text")
	TextBlock successMsg;

	public boolean viewUsage() {
		return (payGAllowanceTabs.selectUsageTab());
	}

	public void packTab() {
		//payGPacksTab.changePack();
		choosePackTab.click();
		choosePackTab.chooseDataPack();
	}

	public void selectUsage() {
		payGAllowanceTabs.selectUsageTab();
	}

	public void buyAddons() {
		waiter.waitForLoad();
		addOnsTab.click();
		addonsSection.selectBuyAddon();
			Assert.assertTrue(successMsg.getText().contains("add on purchased"));
		
		
		
	}
}
