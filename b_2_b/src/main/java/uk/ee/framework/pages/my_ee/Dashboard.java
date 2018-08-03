package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.sections.my_ee.BuyAddonsMBB;

import uk.ee.framework.elements.sections.my_ee.CurrentCredit;
import uk.ee.framework.elements.sections.my_ee.CurrentPack;
import uk.ee.framework.elements.sections.my_ee.CurrentUsage;
import uk.ee.framework.elements.sections.my_ee.DeviceAndPlan;
import uk.ee.framework.elements.sections.my_ee.LastBill;
import uk.ee.framework.elements.sections.my_ee.Menu;
import uk.ee.framework.elements.sections.my_ee.PayGAllowanceSectionDashboard;
import uk.ee.framework.elements.sections.my_ee.RemainingAllowances;
import uk.ee.framework.elements.sections.my_ee.TopTasks;
import uk.ee.framework.elements.sections.my_ee.mobile.HeaderDevice;
import uk.ee.framework.elements.sections.my_ee.mobile.MobileMenu;
import uk.ee.framework.pages.BasePage;
import uk.ee.framework.utils.Waiter;

/**
 * Modified by prabhu_s on 08/02/16.
 */
@Component
@Scope("prototype")
public class Dashboard extends BasePage {

	@FindBy(css = "div.latest-bill")
	LastBill lastBill;

	@FindBy(xpath = "//*[@id='menuIconContainer']/a")
	Menu menuIcon;

	@FindBy(css = "div.panel.current-usage.white.clearfix")
	CurrentUsage currentUsage;

	@FindBy(css = "div.col.span-4.mod-other-tasks>div>ul")
	TopTasks topTasks;

	@FindBy(css = "div.col.span-6.mod-current-credit")
	CurrentCredit currentCredit;

	@FindBy(css = "div.col.span-6.mod-current-pack")
	CurrentPack currentPack;
	
	@FindBy(xpath ="//div[@class='col span-6 mod-current-credit']")
	BuyAddonsMBB buyAddons;
	
	@FindBy(xpath ="//*[@id='main']/section[3]/form/div/div/div/span")
	RemainingAllowances remainingAllowances;

	@FindBy(css = "a.closeBtn")
	Button closeButton;

	@FindBy(css = "div.panel.device.white.clearfix")
	DeviceAndPlan deviceAndPlanPaym;
	
	@FindBy(css="div.col.span-4.mod-single-device")
	DeviceAndPlan deviceAndPlanMbb;
	
	@FindBy(css = "div.greetings-pane>h2")
	WebElement sbuser;

	@FindBy(id = "topText")
	WebElement noOfDevices;

	@FindBy(xpath = "//*[@id='main']/form/section[3]/div[2]/div[2]/div[2]/div")
	DeviceAndPlan deviceAndPlanSB;

	@FindBy(xpath = "(//form[@class='ee-form'])[2]")
	PayGAllowanceSectionDashboard paygAllowance;

	@FindBy(xpath = "//a[@class='closeBtn']")
	Menu closeBtn;

	// Device
	// @FindBy(id="eed-off-canvas-toggle")
	// eed-header__inner.js-eed-header-inner.container
	@FindBy(css = "a[href*='#eed-off-nav'][id='eed-off-canvas-toggle']")
	HeaderDevice menuHeader;

	@FindBy(xpath = "//div[@id='ee-off-nav-0']/ul[@class='js-eed-off-nav-menu eed-off-nav-menu eed-off-nav-menu--first']")
	MobileMenu deviceMenu;

	@FindBy(xpath = "//div[@id='ee-off-nav-1']")
	HeaderDevice mobileMyEEMenu;

	@FindBy(xpath = "//*[@id='accessible-megamenu-1451869117121-2']")
	Button myEEMenuDevice;

	public void clickPayment() {
		lastBill.makePayment();
	}

	public void clickMenuBillsAndPayments() {
		try {
			if (null != System.getProperty("type") && !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
				// waiter.implicitWait();
				boolean status = new Waiter(browser).isClickable(closeBtn);
				if (status) {
					menuIcon.menuBillsAndPayments();
				}

				else {
					menuIcon.click();
					menuIcon.menuBillsAndPayments();
				}

			} else {
				// waiter.implicitWait();
				waiter.elementIsPresent(menuHeader);
				menuHeader.click();
				deviceMenu.mobileMenuMyEE();
				mobileMyEEMenu.mobileMenuBillsAndPayments();
			}
		} catch (WebDriverException exception) {
			menuIcon.menuBillsAndPayments();
		}
	}

	public void clickMenuInvoiceAndPayments() {
		try {
			if (null != System.getProperty("type") && !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
				boolean status = new Waiter(browser).isClickable(closeBtn);
				if (status) {
					menuIcon.menuinvoiceAndPayments();
				} else {
					menuIcon.click();
					menuIcon.menuinvoiceAndPayments();
				}
				
				/*closeButton.click();
				menuIcon.click();
				menuIcon.menuBillsAndPayments();*/
				 
			} else {
				// waiter.implicitWait();
				waiter.elementIsPresent(menuHeader);
				menuHeader.click();
				deviceMenu.mobileMenuMyEE();
				mobileMyEEMenu.menuinvoiceAndPayments();

			}
		} catch (WebDriverException exception) {
			menuIcon.menuinvoiceAndPayments();
		}
	}

	public void clickUsage() {
		currentUsage.viewAllowances();
	}

	public void clickTopUpHistory() {
		waiter.scrollToElement(topTasks);
		topTasks.viewTopUpHistory();
	}

	public void viewCurrentCredit() {
		System.out.println("currentCredit.viewCurrentCreditDetails(): " + currentCredit.viewCurrentCreditDetails());
	}

	public void viewPackInfo() {
		System.out.println("currentPack.viewCurrentPackInfo(): " + currentPack.viewCurrentPackInfo());
	}

	public void clickMenuManageDevice() {
		try {
			if (null != System.getProperty("type") && !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
				boolean status = new Waiter(browser).isClickable(closeBtn);
				if (status) {
					menuIcon.menuManageDevice();
				} else {
					menuIcon.click();
					menuIcon.menuManageDevice();
				}

			} else {

				menuHeader.click();

				myEEMenuDevice.click();
				menuIcon.menuManageDevice();
			}

		} catch (WebDriverException exception) {
			menuIcon.menuManageDevice();
		}
	}

	public void clickMenuAccountSettings() {
		try {
			if (null != System.getProperty("type") && !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
				boolean status = new Waiter(browser).isClickable(closeBtn);
				if (status) {
					menuIcon.menuAccountSettings();
				} else {
					menuIcon.click();
					menuIcon.menuAccountSettings();
				}
			} else {
				menuHeader.click();
				myEEMenuDevice.click();
				menuIcon.menuAccountSettings();
			}
		} catch (WebDriverException exception) {
			menuIcon.menuAccountSettings();
		}
    }
    

	public String remainingAllowances() {
		return remainingAllowances.checkRemainingAllowances();
	}

	public void clickTopUpBtn() {
		currentCredit.clickTopUpBtn();
	}

	public void clickMenuPackAndAddOns() {
		try {
			if (null != System.getProperty("type") && !"mobile".equalsIgnoreCase(System.getProperty("type"))) {

				boolean status = new Waiter(browser).isClickable(closeBtn);
				if (status) {
					menuIcon.click();
					menuIcon.menuPackAndAddonsBrow();
				} else {

					menuIcon.menuPackAndAddonsBrow();
				}
				/*
				 * closeButton.click(); menuIcon.click();
				 * menuIcon.menuPackAndAddons();
				 */
			} else {
				menuHeader.click();
				myEEMenuDevice.click();
				menuIcon.menuPackAndAddonsBrow();
			}
		} catch (WebDriverException exception) {
			menuIcon.menuPackAndAddonsBrow();
		}
	}

	public void viewDevicesAndPlansPayM() {
		deviceAndPlanPaym.viewPayMDevicesAndPlansInfo();
	}

	public void viewDevicesAndPlansSB() {
		System.out.println(deviceAndPlanSB.viewSBDevicesAndPlansInfo());
	}

	public void getBillDetails() {
		System.out.println(lastBill.getBillDetails());
	}

	public String getDevicesCount() {
		return noOfDevices.getText();
	}

	public String getSBUserName() {
		return sbuser.getText();
	}

	public void clickMenuCurrentUsage() {
		try {
			if (null != System.getProperty("type") && !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
				// waiter.implicitWait();
				boolean status = new Waiter(browser).isClickable(closeBtn);
				if (status) {
					menuIcon.menuCurrentUsage();
				}

				else {
					menuIcon.click();
					menuIcon.menuCurrentUsage();
				}

			} else {
				// waiter.implicitWait();
				waiter.elementIsPresent(menuHeader);
				menuHeader.click();
				deviceMenu.mobileMenuMyEE();
				mobileMyEEMenu.mobileMenuCurrentUsage();
			}
		} catch (WebDriverException exception) {
			menuIcon.menuCurrentUsage();
		}
	}

	public String viewPayGAllowances() {
		return paygAllowance.allowanceSection();
	}
    
    
    public void validatePaygMbbUser() {
    	currentCredit.viewCurrentCreditDetails();
    	buyAddons.validateBuyAddonSection();
    	deviceAndPlanMbb.viewMBBDevicesInfo();
	}
    
    
}