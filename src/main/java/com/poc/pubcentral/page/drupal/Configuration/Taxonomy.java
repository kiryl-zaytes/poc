package com.poc.pubcentral.page.drupal.Configuration;

import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.page.Page;
import com.poc.pubcentral.page.drupal.block.AddVocabulary;
import com.poc.pubcentral.page.drupal.block.LocalActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.yandex.qatools.htmlelements.element.Button;

/**
 * Created by kiryl_zayets on 10/15/15.
 */
@Configuration
@Scope("prototype")
@PageMarker
public class Taxonomy extends Page {


    @FindBy(css = "#edit-delete")
    Button delete;


    LocalActions localActions;
    AddVocabulary vocabulary;

    String elemntPattern = "//tr[contains(.,'%s')" +
            "]//div[@class='dropbutton-widget']//button";
    String subItem = "//tr[contains(.,'%s')" +
            "]//div[@class='dropbutton-widget']//li[contains(@class,'edit')]";

    public String add(String name, String description, String machineName) {
        localActions.clickAddVocabulary();
        vocabulary.addVocabulary(name, description, machineName);
        return getStatusText();
    }

    public String delete(String name) {
        goToUpdateScreen(name);
        delete.click();
        button.click(webDriver);
        return getStatusText();
    }

    public String update(String oldName, String newName) {
        goToUpdateScreen(oldName);
        vocabulary.updateName(newName);
        button.click(webDriver);
        return getStatusText();
    }


    public void goToUpdateScreen(String name) {
        webDriver.findElement(By.xpath(String.format(elemntPattern, name)))
                .click();
        webDriver.findElement(By.xpath(String.format(subItem, name))).click();
    }
}
