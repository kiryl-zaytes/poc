package uk.ee.framework.pages.shop;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.sections.global.GlobalHeader;
import uk.ee.framework.elements.sections.global.GlobalHeaderMobile;
import uk.ee.framework.elements.sections.my_ee.mobile.HeaderDevice;

import uk.ee.framework.elements.sections.shop.DeviceList;

import uk.ee.framework.pages.BasePage;
import uk.ee.framework.post_processor.Loggable;
import uk.ee.framework.site_map.ShopMap;

/**
 * Created by prabhu_s on 6/23/16.
 */

@Component
@Scope("prototype")
public class ShopLanding extends BasePage {

	@Loggable
	protected Logger logger;

	@FindBy(css = "div.parsys.global-masthead-new")
	GlobalHeader globalHeader;

	@Autowired
	ShopMap shopMap;

	private DeviceList deviceList;

	@Autowired
	SimOnly simOnly;

	@Autowired
	ChooseSIMOPlan chooseSIMOPlan;

	@FindBy(xpath = "(//span[text()='Shop'])[2]")
	WebElement shopLink;


	
	@FindBy(css="div.eed-header__inner.js-eed-header-inner.container")
	GlobalHeaderMobile globalHeaderMobile;
	/*Device
	*/
	@FindBy(css="a[href*='#eed-off-nav'][id='eed-off-canvas-toggle']")
	HeaderDevice menuHeadeer;
	
	/**
	 * This method is used to navigate to the Shop Landing screen.
	 *
	 * @return
	 */
	public ShopLanding launchShopLandingPage() {
		browser.get(shopMap.SHOP);
		return this;
	}

	/**
	 * This method is used to navigate to the RSA Landing screen.
	 *
	 * @return
	 */
	public ShopLanding launchRSALandingPage() {
		browser.get(shopMap.RSA_URL);
		return this;
	}

	/**
	 * @param element
	 */
	public void launch(WebElement element) {
		element.click();
	}

	/**
	 * This method is used to navigate to the Business screen.
	 */
	public void navigateSmallBusiness() {
    	if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
    		globalHeader.navigateSmallBusiness();
    		
    	} else{
    		globalHeaderMobile.navigateSmallBusinessMobile();
    	}
	}

	/**
	 * This method is used to navigate to the SB screen.
	 */
	public void navigateSBPhones() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.navigateSBShop(browser);
    		
    	} else{
    		globalHeaderMobile.navigateSBShop();
    	}
		
	}

	/**
	 * This method is used to navigate to the MBB screen.
	 */
	public void navigateMBB() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.navigateToMBB(browser);
    		
    	} else{
    		globalHeaderMobile.navigateToMBB();
    	}

	}

	/**
	 * This method is used to navigate to the Paym Phones screen.
	 */
	public void navigatePaymPhones() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.navigateToPaymPhones(browser);
    		
    	} else{
    		globalHeaderMobile.navigateToPaymPhones();
    	}
	}

	/**
	 * This method is used to navigate to the Payg Phones screen.
	 */
	public void navigatePaygPhones() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.navigateToPaygPhones(browser);
    		
    	} else{
    		globalHeaderMobile.navigateToPaygPhones();
    	}

	}

	/**
	 * This method is used to navigate to the Tablets screen.
	 */
	public void navigateTablets() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.navigateToTablets(browser);
    		
    	} else{
    		globalHeaderMobile.navigateToTablets();
    	}
	}

	/**
	 * This method is used to navigate to the SIMO screen.
	 */
	public void launchSIMO() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.launchToSIMO(browser);
    		
    	} else{
    		globalHeaderMobile.launchToSIMO();
    	}

	}

	/**
	 *
	 */
	public void navigateSBSIMO() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.navigateSBSIMO(browser);
    		
    	} else{
    		globalHeaderMobile.navigateSBSIMO();
    	}
	}


	public void navigateSBMBB() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.navigateSBMBB(browser);
    		
    	} else{
    		globalHeaderMobile.navigateSBMBB();
    	}	
	}

	/**
	 *
	 */
	public void navigateSBTablets() {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.navigateSBTablets(browser);
    		
    	} else{
    		globalHeaderMobile.navigateSBTab();
    	}	
		
	}

	public ShopLanding launchShopRSALandingPage() {
		logger.debug("Entered into ShopLanding.launchShopRSALandingPage");
		browser.get(shopMap.RSA_URL);
		return this;
	}

	public void mouseOverFunctionality(final WebElement path) {
		Actions action = new Actions(browser);
		action.moveToElement(path).build().perform();
	}

	public void navigateLargeBusiness() {
    	if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
    		globalHeader.navigateLargeBusiness();
    		
    	} else{
    		globalHeaderMobile.navigateLargeBusinessMobile();
    	}
	}

	public void shopSearch(String s){
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.globalSearch(s);
    		
    	} else{
    		globalHeaderMobile.globalqSearch(s, browser);
    	}
		
	}

	/**
	 * This method is used to navigate to the Shop Paym Upgrades screen.
	 * 
	 * @return
	 */
	public ShopLanding launchShopPaymUpgrade() {
		browser.get(shopMap.PAYM_UPGRADES);
		return this;
	}

	public int goToGalleryAndGetDevicesCount(String gallery) {
		logger.info("Entering gallery " + gallery);
		browser.get(gallery);
		logger.info("Searching for devices on the page and return it's count");
		int itemsNum;
		if (gallery.equals(shopMap.PAYG_SIMS)) {
			itemsNum = chooseSIMOPlan.getPlansCount();
		} else if (gallery.equals(shopMap.PAYM_SIMS)) {
			itemsNum = simOnly.getSimsCount();
		} else {
			itemsNum = deviceList.getDevicesCount();
		}
		return itemsNum;
	}
}
