package uk.ee.framework.pages;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import uk.ee.framework.elements.webdriver_aware.WebDriverAwareDecorator;
import uk.ee.framework.utils.ConfirmationPopUp;
import uk.ee.framework.utils.Waiter;

/**
 * Created by kiryl_zayets on 4/28/16.
 * 
 * Modified by Syamphaneendra kalluri on 08/03/16.
 */

public class BasePage {
	@Autowired
	protected WebDriver browser;

	protected Waiter waiter;

	@PostConstruct
	public void initElements() {
		System.out.println("INIT ELEMENTS" + browser + " ---- " + Thread.currentThread());
		PageFactory.initElements(new WebDriverAwareDecorator(new HtmlElementLocatorFactory(browser), browser), this);
		// The below logic is used to maximize rhe browser window based on the
		// type of device
		if (null == System.getProperty("spring.profiles.active")) {
			browser.manage().window().maximize();
		} else if (!"mobileLocal".equalsIgnoreCase(System.getProperty("spring.profiles.active"))) {
			browser.manage().window().maximize();
		}
		waiter = new Waiter(browser);
	}
	
	/**
	 * For closeThePopUp
	 * @param popUp 
	 */
	public void closeThePopUp(final String yesOrNo, ConfirmationPopUp popUp) {
		String myWindowHandle = browser.getWindowHandle();
		if (null != myWindowHandle) {
			browser.switchTo().window(myWindowHandle);
			popUp.selectBtn(yesOrNo);
		}
	}

}