package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.sections.my_ee.LoginSection;
import uk.ee.framework.elements.sections.my_ee.MyEEHeader;
import uk.ee.framework.pages.BasePage;
import uk.ee.framework.site_map.MyEEMap;

/**
 * Created by kiryl_zayets on 4/28/16.
 */
@Component
@Scope("prototype")
public class HomePage extends BasePage {

    @Autowired
    MyEEMap myEEMap;
    
    @FindBy(id = "janrain-login-form")
    LoginSection loginSection;

    @FindBy(id = "ee-masthead")
    MyEEHeader myEEHeader;

    @FindBy(name = "Continue")
    private WebElement secuAlertConf;

    @FindBy(id = "android:id/alertTitle")
    private WebElement secuAlert;
   
    @FindBy(name = "ctnMobilecheck")
    private WebElement mobilectn;

//    @FindBy(xpath ="//*[@id='ctn-enter-number-popup-container']/div")
    @FindBy(xpath ="//label[@for='ctnMobilecheck']")
    Button mobileradio;

    @FindBy(id="find-your-number-panel-link")
    private WebElement dontknownolink;

    @FindBy(id = "brand-section-link")
    private WebElement brandlink;

    @FindBy(xpath = "//div[@id='brand-Panel']/a/div")
    private WebElement eebutton;

    public HomePage launchMyee(){
    	browser.get(myEEMap.myEE);
    	return this;
    }

    public HomePage login(User user) {
        mobileradio.click();
        waiter.elementIsPresent(dontknownolink).click();
        brandlink.click();
        eebutton.click();
        loginSection.login(user);
        return this;
        
    }

    public String getLoggedUser(){
        return myEEHeader.getLoggedInInfo();
    }

}
