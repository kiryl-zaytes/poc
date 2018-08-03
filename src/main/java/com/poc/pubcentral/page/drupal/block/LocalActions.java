package com.poc.pubcentral.page.drupal.block;

import com.poc.pubcentral.customcontrols.CustomButton;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by kiryl_zayets on 10/15/15.
 */

@FindBy(css = "#block-primaryadminactions")
public class LocalActions extends HtmlElement {

    @FindBy(css = "a[href$='taxonomy/add']")
    private CustomButton addVocabulary;

    @FindBy(css = "a[href$='create']")
    private CustomButton addUser;

    public void clickAddUser() {
        addUser.click();
    }

    public void clickAddVocabulary() {
        addVocabulary.click();
    }
}
