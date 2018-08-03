package uk.ee.framework.business_flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.pages.web.WebHomePage;

/**
 * Updated by prabhu_S on 5/23/16.
 */

@Component
@Scope("prototype")
public class WebLogic {
	@Autowired WebHomePage webHomePage;
	
	public void webToMyeeNavigation(){
		webHomePage.launchWeb();
		webHomePage.webToMyee();
	}
	public void webToShopNavigation(){
		webHomePage.launchWeb();
		webHomePage.webToShop();
	}

}