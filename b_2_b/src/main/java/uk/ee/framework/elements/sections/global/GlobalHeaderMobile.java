package uk.ee.framework.elements.sections.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.elements.sections.my_ee.mobile.HeaderDevice;
import uk.ee.framework.utils.Waiter;

/**
 * Created by prabhu S on 07/07/16.
 */
public class GlobalHeaderMobile extends GlobalHeader {

    @FindBy(xpath="//a[span[text()='Shop']]")
    Link personalShopMob;
    @FindBy(xpath="//span[text()='See all shop']")
    WebElement personalShopAll; 

    @FindBy(xpath="(//a[span[text()='Phones']])[1]")
    Link phonesMob;
	@FindBy(xpath = "(//a[contains(text(),'Pay monthly phones')])[1]")
	Link paymPhones;
	@FindBy(xpath = "(//a[contains(text(),'Pay as you go phones')])[1]")
	Link paygPhones;
	@FindBy(xpath = "(//span[text()='Tablets'])[1]")
	Link tablets;
	@FindBy(xpath="(//a[span[text()='SIMs']])[1]")
	Link sims;
	@FindBy(xpath="(//a[contains(text(),'SIM Only')])[1]")
	Link simOnly;
	@FindBy(xpath = "(//a[span[text()='Mobile Broadband']])[1]")
	WebElement mbb;
	@FindBy(xpath = "(//a[contains(text(),'Mobile Broadband')])[1]")
	WebElement mbbAll;
    @FindBy(css="a[href*='#eed-off-nav'][id='eed-off-canvas-toggle']")
	HeaderDevice menuHeader;
    
    @FindBy(xpath="//span[text()='Switch to Business']")
    WebElement switchtoBusiness;
    
    @FindBy(xpath="//a[span[text()='SMALL BUSINESS']]")
    WebElement smallBusiness;
	@FindBy(xpath = "//a[span[text()='LARGE BUSINESS']]")
	Button largeBusiness;
    
    @FindBy(xpath="//a[span[text()='SHOP']]")
    WebElement sbShop;
    
	@FindBy(xpath = "//span[text()='Phones']")
	WebElement sbPhones;
	@FindBy(xpath = "//span[text()='SIM only']")
	WebElement sbSIMO;
	@FindBy(xpath = "//span[text()='Mobile Broadband']")
	WebElement sbMBB;
	@FindBy(xpath = "(//span[text()='Tablets'])[2]")
	WebElement sbTablets;

	@FindBy(css="a.js-eed-header-search-toggle.eed-header__control.eed-header-search-toggle")
	WebElement searchIconMobile;
	@FindBy(id = "q")
	TextInput search;

	@FindBy(id = "searchform-submit")
	Button searchIcon;
	
    public void webToShop() {
    	menuHeader.click();
    	personalShopMob.click();
    	waiter.elementVisible(personalShopAll);
    	personalShopAll.click();
    }

    public GlobalHeader webToMyEE() {
       super.webToMyEE();
        return this;
    }
    
	public void navigateSmallBusinessMobile() {
		menuHeader.click();
		switchtoBusiness.click();
		smallBusiness.click();
	}

	public void navigateSBShop() {
		menuHeader.click();
		sbShop.click();
		sbPhones.click();
	}

	public void navigateSBSIMO() {
		menuHeader.click();
		sbShop.click();
		sbSIMO.click();				
	}

	public void navigateSBMBB() {
		menuHeader.click();
		sbShop.click();
		sbMBB.click();
	}

	public void navigateSBTab() {
		menuHeader.click();
		sbShop.click();
		sbTablets.click();
	}
	
	public void navigateLargeBusinessMobile() {
		menuHeader.click();
		switchtoBusiness.click();
		largeBusiness.click();
	}

	public void navigateToTablets() {
    	menuHeader.click();
    	personalShopMob.click();
    	tablets.click();
	}

	public void navigateToPaymPhones() {
    	menuHeader.click();
    	personalShopMob.click();
    	phonesMob.click();
    	paymPhones.click();
	}

	public void navigateToPaygPhones() {
    	menuHeader.click();
    	personalShopMob.click();
    	phonesMob.click();
    	paygPhones.click();
	}

	public void launchToSIMO() {
    	menuHeader.click();
    	personalShopMob.click();
    	sims.click();
    	simOnly.click();
	}

	public void navigateToMBB() {
    	menuHeader.click();
    	personalShopMob.click();
    	mbb.click();
    	mbbAll.click();    	
	}

	public void globalqSearch(String str, WebDriver browser) {
		waiter.elementIsPresent(searchIconMobile);
		searchIconMobile.click();
		search.sendKeys(str);
		searchIcon.click();
//		return str;
	}
	
	
}
