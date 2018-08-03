package com.poc.pubcentral.page.content.block;

import com.poc.pubcentral.bo.RelatedType;
import com.poc.pubcentral.customcontrols.CustomButton;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/19/15.
 */
@FindBy(css = "#block-base-mainpagecontent")
public class MediaInfo extends HtmlElement {

    @FindBy(css = "#edit-field-genre")
    Select genre;

    @FindBy(css = "#edit-field-rating")
    Select rating;

    @FindBy(css = "#edit-field-program-status")
    Select programStatus;

    @FindBy(css = "#edit-field-related-series-0-target-id")
    TextInput relatedSeries;

    @FindBy(css = "#edit-field-related-series-add-more")
    CustomButton addMoreItem;

    public void fill(RelatedType info) {
        genre.selectByVisibleText(info.getGenre());
        rating.selectByVisibleText(info.getRating());
        programStatus.selectByVisibleText(info.getProgramStatus());
        relatedSeries.sendKeys(info.getRelatedSeries());
    }
}
