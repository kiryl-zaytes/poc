package uk.ee.framework.pages.web;

import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.sections.global.GlobalHeader;
import uk.ee.framework.elements.sections.global.GlobalHeaderMobile;
import uk.ee.framework.pages.BasePage;
import uk.ee.framework.site_map.WebMap;

/**
 * Created by prabhu_s on 5/16/16.
 */
@Component
@Scope("prototype")
public class WebHomePage extends BasePage{

	@Autowired
	WebMap webMap;
	
	@FindBy(css = "div.parsys.global-masthead-new")
	GlobalHeader globalHeader;

	@FindBy(css="div.eed-header__inner.js-eed-header-inner.container")
	GlobalHeaderMobile globalHeaderMobile;

	@FindBy(css = "a#eed-off-canvas-toggle")
	Link hamburgerMenu;

	public WebHomePage launchWeb(){
		browser.get(webMap.webUrl);
		return this;
	}
	
	public WebHomePage webToMyee(){
		getGlobalHeader().webToMyEE();
		return this;
	}

	public void webToShop(){
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.webToShop();
    	} else{
    		globalHeaderMobile.webToShop();
    	}
		
	}

	public void webSearch(String str) {
		if (null != System.getProperty("type")
				&& !"mobile".equalsIgnoreCase(System.getProperty("type"))) {
			globalHeader.globalSearch(str);
    		
    	} else{
    		globalHeaderMobile.globalSearch(str);
    	}
		
	}
	
	public GlobalHeader getGlobalHeader() {
		if (System.getProperty("type").equals("mobile")){
			hamburgerMenu.click();
			return globalHeaderMobile;
		}
		if (System.getProperty("type").equals("desktop")){
			return (GlobalHeader)waiter.elementIsPresent(globalHeader);
		}
		return globalHeader;
	}
	
}