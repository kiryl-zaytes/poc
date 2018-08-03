package com.nbc.testautomation.chillertv.page;

import com.nbc.testautomation.webdriver.element.Image;
import com.nbc.testautomation.webdriver.element.TextBlock;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Event Details Page
 */

@Component
@Scope("prototype")
public class EventDetailsPage extends BasePage {

    public static final String PAGE_PATH_PATTERN = "events/%s";

    @FindBy(how = How.CLASS_NAME, using = "qa-event-title")
    private TextBlock eventTitle;

    @FindBy(how = How.XPATH, using = "//picture/img")
    private Image eventImage;

    @FindBy(how = How.CLASS_NAME, using = "qa-long-description")
    private TextBlock eventLongDescription;

    public TextBlock getEventLongDescription() {
        return eventLongDescription;
    }

    public TextBlock getEventTitle() {
        return eventTitle;
    }

    public Image getEventImage() {
        return eventImage;
    }

    public void navigate(String eventId) {
        extendedWebDriver.navigate().to(
                environmentConfiguration.getApplicationUrl() + String.format(PAGE_PATH_PATTERN, eventId));
    }

}
