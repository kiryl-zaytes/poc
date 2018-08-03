package com.poc.pubcentral.page.content.block;

import com.poc.pubcentral.bo.BaseType;
import com.poc.pubcentral.bo.EpisodePojo;
import com.poc.pubcentral.bo.EventPojo;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/19/15.
 */

@FindBy(css = "#block-base-mainpagecontent")
public class BasicInfo extends HtmlElement {

    @FindBy(css = "#edit-title-0-value")
    TextInput title;

    @FindBy(css = "#edit-field-subhead-0-value")
    TextInput subhead;

    @FindBy(css = "#edit-body-0-value")
    TextInput shortDescEvent;

    @FindBy(css = "#edit-field-description-0-value")
    TextInput shortDescSeries;

    @FindBy(css = "#edit-field-medium-description-0-value")
    TextInput mediumDesc;

    @FindBy(css = "#edit-field-long-description-0-value")
    TextInput longDesc;

    @FindBy(css = "#edit-field-categories")
    Select categories;

    @FindBy(css = "#edit-field-tags-target-id")
    TextInput tags;

    public void fill(BaseType info) {
        title.sendKeys(info.getTitle());
        subhead.sendKeys(info.getSubhead());

        if (info.getClass() == EventPojo.class ||
                info.getClass() == EpisodePojo.class) {
            shortDescEvent.sendKeys(info.getShortDescription());
        } else {
            shortDescSeries.sendKeys(info.getShortDescription());
        }

        mediumDesc.sendKeys(info.getMediumDescription());
        longDesc.sendKeys(info.getLongDescription());
        categories.selectByVisibleText(info.getCategories());
        tags.sendKeys(info.getTags());
    }
}
