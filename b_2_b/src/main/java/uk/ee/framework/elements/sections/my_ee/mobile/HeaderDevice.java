package uk.ee.framework.elements.sections.my_ee.mobile;

import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Modified by prabhu_s on 08/02/16. 
 */

public class HeaderDevice extends CustomHtmlElement{

	//PAYM
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'My EE')]")
	Link mobileMenuMyEE;
	
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'Bills & payments')]")
	Link mobileMenuBillsAndPayments;
	
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'Current usage')]")
	Link mobileMenuCurrentUsage;
	
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'Plan & add-ons')]")
	Link mobileMenuPlanAndAddons;
	
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'Manage device')]")
	Link mobileMenuManageDevice;
	
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'Account settings')]")
	Link mobileMenuAccountSettings;
	
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'Log out')]")
	Link mobileMenuLogout;
	
	//PAYG
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'Top up')]")
	Link mobileMenuTopUp;
	
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'Pack and add-ons')]")
	Link mobileMenuPackAndAddons;
	
	@FindBy(xpath = "//a[@class='js-eed-off-nav-trigger']/span[contains(text(),'bills']")
	Link menuInvoiceAndPayments;
	
	public void mobileMenuMyEE() {
		mobileMenuMyEE.click();
	}
	
	public void mobileMenuBillsAndPayments() {
		mobileMenuBillsAndPayments.click();
	}
	
	public void menuinvoiceAndPayments() {
		menuInvoiceAndPayments.click();
	}
	
	public void mobileMenuCurrentUsage() {
		mobileMenuCurrentUsage.click();
	}
	
	public void mobileMenuPlanAndAddons() {
		mobileMenuPlanAndAddons.click();
	}
	
	public void mobileMenuManageDevice() {
		mobileMenuManageDevice.click();
	}
	
	public void mobileMenuAccountSettings() {
		mobileMenuAccountSettings.click();
	}
	
	public void mobileMenuLogout() {
		mobileMenuLogout.click();
	}
	
	public void mobileMenuPacksAndAddOns() {
		mobileMenuPackAndAddons.click();
	}
	
}
