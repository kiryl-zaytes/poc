package uk.ee.framework.elements.sections.my_ee.mobile;

import org.openqa.selenium.support.FindBy;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class MobileMenu extends CustomHtmlElement {

	@FindBy(xpath = "//a[@class='js-eed-nav-drop-trigger eed-off-nav-drop-trigger  eed-off-nav__level-trigger eed-off-nav__level-trigger--not-selected']/span[contains(text(),'My EE')]")
	Link mobileMenuMyEE;

	@FindBy(xpath = "//a[@class='js-eed-nav-drop-trigger eed-off-nav-drop-trigger  eed-off-nav__level-trigger eed-off-nav__level-trigger--not-selected']/span[contains(text(),'Shop')]")
	Link mobileMenuShop;
	
	@FindBy(xpath = "//a[@class='js-eed-nav-drop-trigger eed-off-nav-drop-trigger  eed-off-nav__level-trigger eed-off-nav__level-trigger--not-selected']/span[contains(text(),'Help')]")
	Link mobileMenuHelp;
	
	@FindBy(xpath = "//a[@class='js-eed-nav-drop-trigger eed-off-nav-drop-trigger  eed-off-nav__level-trigger eed-off-nav__level-trigger--not-selected']/span[contains(text(),'Why EE')]")
	Link mobileMenuWhyEE;
	
	
	public void mobileMenuMyEE() {
		mobileMenuMyEE.click();
	}
	
	public void mobileMenuShop() {
		mobileMenuShop.click();
	}
	
	public void mobileMenuHelp() {
		mobileMenuHelp.click();
	}
	
	public void mobileMenuWhyEE() {
		mobileMenuWhyEE.click();
	}

}
