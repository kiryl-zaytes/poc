package uk.ee.framework.elements.sections.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
import uk.ee.framework.site_map.ShopMap;

public class GlobalHeader extends CustomHtmlElement {

	@FindBy(xpath = "//span[contains(text(),'Log in / Register')]")
	Link myeeHeaderLogIn;

	@FindBy(xpath = "(//span[text()='Shop'])[2]")
	WebElement shopLink;

	@Autowired
	ShopMap shopMap;

	@FindBy(xpath = "//a[contains(text(),'iPhones')]")
	Link iPhones;

	@FindBy(xpath = "(//a[contains(text(),'Android phones')])[2]")
	WebElement androidPhones;

	@FindBy(xpath = "(//a[contains(text(),'Pay monthly phones')])[2]")
	Link paymPhones;

	@FindBy(xpath = "(//a[contains(text(),'Pay as you go phones')])[2]")
	Link paygPhones;

	@FindBy(xpath = "(//span[contains(text(),'SIM only')])[2]")
	Link simOnly;

	@FindBy(xpath = "//a[contains(text(),'Plan & Packs')]")
	Link planAndPacks;

	@FindBy(xpath = "//a[contains(text(),'Pay monthly phone plans')]")
	Link paymPhonePlans;

	@FindBy(xpath = "//a[contains(text(),'Pay monthly data plans')]")
	Link paymDataPlans;

	@FindBy(xpath = "//a[contains(text(),'Pay as you go packs')]")
	Link paygPacks;

	@FindBy(xpath = "//a[contains(text(),'Upgrades')]")
	Link upgrades;

	@FindBy(xpath = "(//span[text()='Tablets'])[2]")
	Link tablets;

	@FindBy(xpath = "//a[contains(text(),'iPads')]")
	Link ipads;

	@FindBy(xpath = "//a[contains(text(),'Android tablets')]")
	Link androidTablets;

	@FindBy(xpath = "//a[contains(text(),'Cameras')]")
	Link cameras;

	@FindBy(xpath = "//a[contains(text(),'Accessories')]")
	Link accessories;

	// @FindBy(xpath = "(//span[text()='Mobile broadband'])[2]")
	@FindBy(xpath = "(//span[text()='Mobile broadband'])[2]")
	WebElement mbb;

	@FindBy(xpath = "//a[contains(text(),'Car WiFi')]")
	Link carWIFI;

	@FindBy(xpath = "//a[contains(text(),'Home Broadband')]")
	Link homeBB;

	@FindBy(xpath = "//a[contains(text(),'EE TV')]")
	Link eeTV;

	@FindBy(xpath = "//a[contains(text(),'Deal')]")
	Link deals;

	@FindBy(xpath = "//a[contains(text(),'All deals')]")
	Link allDeals;

	@FindBy(xpath = "//a[contains(text(),'EE customer offers')]")
	Link eeCustomerOffers;

	@FindBy(xpath = "(//span[text()='Phones'])[2]")
	WebElement sbPhones;

	@FindBy(xpath = "(//span[text()='SIM only'])[2]")
	WebElement sbSIMO;

	@FindBy(xpath = "(//span[text()='Mobile Broadband'])[2]")
	WebElement sbMBB;
	
	@FindBy(xpath = "(//span[text()='Tablets'])[2]")
	WebElement sbTablets;

	@FindBy(id = "q")
	TextInput search;

	@FindBy(id = "searchform-submit")
	Button searchIcon;

	@FindBy(xpath = "//a[@id='eed-businessou4u0']")
	WebElement businessLink;

	@FindBy(css = "a.cta-group__button.button.button-primary")
	WebElement smallBusiness;

	@FindBy(xpath = "//a[text()='Large business']")
	Button largeBusiness;
	
	@FindBy(xpath = "(//span[text()='Shop'])[2]")
	WebElement sbShopLink;
	/**
	 * @return
	 */
	public GlobalHeader webToMyEE() {
		myeeHeaderLogIn.click();
		return this;
	}

	/**
	 * @param browser 
	 * @return
	 */
	public GlobalHeader navigateToMBB(WebDriver browser) {
		mouseOverFunctionality(shopLink, browser);
		mbb.click();
		return this;
	}

	/**
	 * @return
	 */
	public GlobalHeader navigateToPaymPhones(WebDriver browser) {
		mouseOverFunctionality(shopLink, browser);
		paymPhones.click();
		return this;
	}

	/**
	 * @return
	 */
	public GlobalHeader navigateToPaygPhones(WebDriver browser) {
		mouseOverFunctionality(shopLink, browser);
		paygPhones.click();
		return this;
	}

	/**
	 * @return
	 */
	public GlobalHeader navigateToTablets(WebDriver browser) {
		mouseOverFunctionality(shopLink, browser);
		tablets.click();
		return this;
	}

	/**
	 * @return
	 */
	public GlobalHeader launchToSIMO(WebDriver browser) {
		mouseOverFunctionality(shopLink, browser);
		simOnly.click();
		return this;
	}

	/**
	 * @return
	 */
	public GlobalHeader navigateSBShop(WebDriver browser) {
		mouseOverFunctionality(sbShopLink, browser);
		sbPhones.click();
		return this;
	}

	/**
	 * @return
	 */
	public GlobalHeader navigateSBSIMO(WebDriver browser) {
		mouseOverFunctionality(sbShopLink, browser);
		sbSIMO.click();
		return this;
	}

	/**
	 * @return
	 */
	public GlobalHeader navigateSBMBB(WebDriver browser) {
		mouseOverFunctionality(sbShopLink, browser);
		sbMBB.click();
		return this;
	}
	
	/**
	 * @return
	 */
	public GlobalHeader navigateSBTablets(WebDriver browser) {
		mouseOverFunctionality(sbShopLink, browser);
		sbTablets.click();
		return this;
	}

	/**
	 * @param str
	 * @return
	 */
	public GlobalHeader globalSearch(String str) {
		search.sendKeys(str);
		searchIcon.click();
		return this;
	}

	/**
	 * 
	 */
	public void webToShop() {
		shopLink.click();
	}
	
	public void  navigateSmallBusiness() {
		businessLink.click();
		smallBusiness.click();
	}
	/**
	 * 
	 */
	public void navigateLargeBusiness() {
		businessLink.click();
		largeBusiness.click();
	}
	
	/**
	 * @param path
	 */
	public void mouseOverFunctionality(final WebElement path, WebDriver browser) {
		Actions action = new Actions(browser);
		action.moveToElement(path).build().perform();
	}


}