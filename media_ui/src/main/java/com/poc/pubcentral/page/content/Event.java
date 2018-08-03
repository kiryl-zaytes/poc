package com.poc.pubcentral.page.content;

import com.poc.pubcentral.bo.EventPojo;
import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.customcontrols.CustomButton;
import com.poc.pubcentral.page.Page;
import com.poc.pubcentral.page.content.block.BasicInfo;
import com.poc.pubcentral.page.content.block.MediaInfo;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/19/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Event extends Page {

    BasicInfo basicInfo;
    MediaInfo mediaInfo;

    @FindBy(css = "#edit-field-event-type")
    Select eventType;

    @FindBy(css = "#edit-field-related-series-add-more")
    CustomButton addMoreItem;

    @FindBy(css = "#edit-field-release-year-0-value")
    TextInput releaseYear;

    @FindBy(css = "#edit-field-air-times-0-value")
    TextInput airTimes;

    @FindBy(css = "#edit-actions input[type='submit']")
    CustomButton submit;

    public String create(EventPojo eventPojo) {
        this.navigate(pageMapping.CREATE_EVENT);
        basicInfo.fill(eventPojo);
        mediaInfo.fill(eventPojo);
        eventType.selectByVisibleText(eventPojo.getEventType());
        submit.click();
        return getStatusText();
    }
}
