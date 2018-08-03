package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Link;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class SBCartOverlay extends CustomHtmlElement{
	
	@FindBy(css="div.modal-content")
	WebElement overlay;
	

	@FindBy(xpath ="(//*[@id='business_type_modal']/div/section/p[2]/a[1])[2]")
	Link soleTrader;
	
	public void soleTraderClick() {
	
	soleTrader.click();
	}
}
