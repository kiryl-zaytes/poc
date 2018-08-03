package com.poc.pubcentral.page.drupal.block;

import com.poc.pubcentral.customcontrols.CustomButton;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/15/15.
 */

@FindBy(css = "#taxonomy-vocabulary-form")
public class AddVocabulary extends HtmlElement {

    @FindBy(css = "#edit-name")
    private TextInput userName;

    @FindBy(css = "#edit-description")
    private TextInput description;

    @FindBy(css = "#edit-vid")
    private TextInput machineReadableName;

    @FindBy(css = "#edit-submit")
    private CustomButton save;


    public void addVocabulary(String name, String desc, String machineName) {
        userName.sendKeys(name);
        description.sendKeys(desc);
        save.click();
        machineReadableName.sendKeys(machineName);
        save.click();
    }

    public void updateName(String name) {
        userName.clear();
        userName.sendKeys(name);
        save.click();
    }


}
