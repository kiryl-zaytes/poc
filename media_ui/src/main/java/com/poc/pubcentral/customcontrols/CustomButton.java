package com.poc.pubcentral.customcontrols;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.Button;

/**
 * Created by kiryl_zayets on 9/13/15.
 */
public class CustomButton extends Button {

    public CustomButton(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void clickjs(WebDriver webDriver) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()" +
                "", this.getWrappedElement());
    }

    public void click(WebDriver webDriver) {
        try {
            this.getWrappedElement().click();
        } catch (StaleElementReferenceException e) {
            this.clickjs(webDriver);
        }
    }
}
