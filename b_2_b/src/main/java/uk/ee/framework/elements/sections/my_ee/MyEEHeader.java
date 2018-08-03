package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by kiryl_zayets on 5/2/16.
 */
public class MyEEHeader extends CustomHtmlElement {

    @FindBy(css = "nav.ee-nav[data-category='ee-and-me']")
    public WebElement myEE;

    @FindBy(css = "nav.ee-nav[data-category='shop']")
    public WebElement shop;

    @FindBy(css = "nav.ee-nav[data-category='help']")
    public WebElement help;

    @FindBy(css = "div.ee-masthead-auth--logged-in")
    public WebElement loggeInInfo;

    public String getLoggedInInfo(){
        return loggeInInfo.getText();
    }

}
