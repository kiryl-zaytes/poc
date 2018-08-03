package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
import uk.ee.framework.utils.Waiter;

/**
 * Created by prabhu_s on 5/12/16.
 * 
 * Modified by prabhu_s on 08/02/16.
 */
public class Menu extends CustomHtmlElement {

	@FindBy(xpath = "//a[@data-section='bills']")
	Link menuBillAndPayments;
	
	@FindBy(xpath = "//a[@data-section='bills']")
	Link menuInvoiceAndPayments;

	@FindBy(xpath = "//a[@data-section='device']")	
	Link menuManageDevice;

	@FindBy(xpath = "//a[@data-section='settings']")
	Link menuAccountSettings;
	
	@FindBy(xpath = "//a[@data-section='plan']")
	Link menuPackAndAddons;
	
	@FindBy(xpath = "//a[@data-section='usage']")
	Link menuCurrentUsage;
	
	public void menuBillsAndPayments() {
		menuBillAndPayments.click();
	}
	
	public void menuinvoiceAndPayments() {
		menuInvoiceAndPayments.click();
	}
	
	public void menuManageDevice() {
		menuManageDevice.click();
	}
	
	public void menuAccountSettings() {
		menuAccountSettings.click();
	}
	
	public void menuPackAndAddonsBrow() {
		menuPackAndAddons.click();
	}

	public void menuCurrentUsage() {
		menuCurrentUsage.click();
	}
}

