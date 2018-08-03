package com.poc.pubcentral.page.drupal;

import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by kiryl_zayets on 10/13/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Extend extends Page {

    @FindBy(css = "#system-modules-confirm-form")
    private WebElement systemMessage;

    private String patternToFindModule = "input#edit-modules-%s-%s-enable";

    public String installModule(String sectionName, String moduleName) {
        String selector = String.format(patternToFindModule, sectionName
                        .replace(" ", "-").toLowerCase(),
                moduleName.replace(" ", "-").toLowerCase());
        webDriver.findElement(By.cssSelector(selector)).click();
        button.click();
        if (waiter.isPresent(systemMessage)) {
            button.click();
        }
        return waiter.elementVisible(statusMessage).getText();
    }


}
