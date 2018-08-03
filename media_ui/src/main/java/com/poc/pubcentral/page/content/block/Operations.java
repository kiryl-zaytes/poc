package com.poc.pubcentral.page.content.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by kiryl_zayets on 11/10/15.
 */

@FindBy(css = "table.views-table tbody")
public class Operations extends HtmlElement {

    String ROW_FORMAT = "//tr/td/a[contains(.,'%s')]";
    String OPERATION_BUTTON = "//td//button";
    String ACTION_FORMAT = "//li/a[contains(.,'%s')]";

    public void delete(String title) {
        WebElement row = this.findElement(By.xpath(String.format(ROW_FORMAT,
                title)));
        row.findElement(By.xpath(OPERATION_BUTTON)).click();
        row.findElement(By.xpath(String.format(ACTION_FORMAT, "Delete")))
                .click();
    }

}
