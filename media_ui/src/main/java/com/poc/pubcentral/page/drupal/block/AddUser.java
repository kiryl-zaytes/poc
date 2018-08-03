package com.poc.pubcentral.page.drupal.block;

import com.poc.pubcentral.bo.UserPojo;
import com.poc.pubcentral.customcontrols.CustomButton;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/14/15.
 */

@FindBy(css = "form#user-register-form")
public class AddUser extends HtmlElement {

    @FindBy(css = "#edit-name")
    private TextInput userName;

    @FindBy(css = "#edit-pass-pass1")
    private TextInput userPass;

    @FindBy(css = "#edit-pass-pass2")
    private TextInput confirmPass;

    @FindBy(css = "#edit-roles-administrator")
    private CheckBox administratorRole;

    @FindBy(css = "#edit-submit")
    private CustomButton createAccount;

    public void addAdmin(UserPojo userPojo) {
        userName.sendKeys(userPojo.getUser());
        userPass.sendKeys(userPojo.getPassword());
        confirmPass.sendKeys(userPojo.getPassword());
        administratorRole.set(true);
        createAccount.click();
    }
}
