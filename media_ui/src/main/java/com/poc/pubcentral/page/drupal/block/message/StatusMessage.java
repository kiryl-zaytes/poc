package com.poc.pubcentral.page.drupal.block.message;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by kiryl_zayets on 10/15/15.
 */

@FindBy(css = ".layout-container")
public class StatusMessage extends HtmlElement {

    @FindBy(css = ".messages.messages--status")
    WebElement messageStatus;


    public String getText() {

        return messageStatus.getText();
    }

}
