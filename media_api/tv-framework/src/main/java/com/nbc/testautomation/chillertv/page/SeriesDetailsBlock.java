package com.nbc.testautomation.chillertv.page;

import com.nbc.testautomation.webdriver.element.HtmlElement;
import com.nbc.testautomation.webdriver.element.Image;
import com.nbc.testautomation.webdriver.element.TextBlock;
import org.openqa.selenium.support.FindBy;

/**
 * Block for representing Series Title, Image, LongDescription in Series Details page Block
 */
public class SeriesDetailsBlock extends HtmlElement {


    @FindBy(className = "qa-series-title")
    protected TextBlock seriesTitle;

    @FindBy(xpath = "//img")
    protected Image seriesImage;

    @FindBy(className = "qa-long-description")
    protected TextBlock seriesLongDescription;


    public TextBlock getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(TextBlock seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    public Image getSeriesImage() {
        return seriesImage;
    }

    public void setSeriesImage(Image seriesImage) {
        this.seriesImage = seriesImage;
    }

    public TextBlock getSeriesLongDescription() {
        return seriesLongDescription;
    }

    public void setSeriesLongDescription(TextBlock seriesLongDescription) {
        this.seriesLongDescription = seriesLongDescription;
    }

}
