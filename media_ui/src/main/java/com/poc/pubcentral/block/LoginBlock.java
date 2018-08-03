package com.poc.pubcentral.block;

import com.poc.pubcentral.bo.UserPojo;
import com.poc.pubcentral.customcontrols.CustomButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 9/13/15.
 */

@Name("Login block")
@FindBy(css = "form#user-login-form")
public class LoginBlock extends HtmlElement {

    @FindBy(css = "#edit-name")
    private TextInput login;

    @FindBy(css = "#edit-pass")
    private TextInput password;

    @FindBy(css = "#edit-submit")
    private CustomButton button;

    public void login(UserPojo userPojo) {
        login.sendKeys(userPojo.getUser());
        password.sendKeys(userPojo.getPassword());
        button.click();
    }

    public void login(UserPojo userPojo, WebDriver webDriver) {
        login.sendKeys(userPojo.getUser());
        password.sendKeys(userPojo.getPassword());
        button.clickjs(webDriver);
    }
}
