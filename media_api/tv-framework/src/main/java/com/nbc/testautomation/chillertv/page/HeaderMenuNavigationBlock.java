package com.nbc.testautomation.chillertv.page;

import com.nbc.testautomation.webdriver.element.HtmlElement;
import com.nbc.testautomation.webdriver.element.Link;
import org.openqa.selenium.support.FindBy;

/**
 * Block for representing header menu navigation
 */
public class HeaderMenuNavigationBlock extends HtmlElement {

    @FindBy(linkText = "Event")
    private Link eventLink;

    public Link getEventLink() {
        return eventLink;
    }

    public void setEventLink(Link eventLink) {
        this.eventLink = eventLink;
    }
}
