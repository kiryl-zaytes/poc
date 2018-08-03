
package com.nbc.testautomation.chillertv.page;

import com.nbc.testautomation.webdriver.element.HtmlElement;
import com.nbc.testautomation.webdriver.element.Image;
import com.nbc.testautomation.webdriver.element.TextBlock;
import org.openqa.selenium.support.FindBy;

/**
 * Block for representing Episode Title, SubHeading, Image, LongDescription in Episode Details Block
 */
public class EpisodeDetailsBlock extends HtmlElement {

    @FindBy(className = "qa-episode-title")
    protected TextBlock episodeTitle;

    @FindBy(className = "qa-subheading")
    protected TextBlock episodeSubHeading;

    @FindBy(xpath = "//picture/img")
    protected Image episodeImage;

    @FindBy(className = "qa-long-description")
    protected TextBlock episodeLongDescription;

    public TextBlock getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(TextBlock episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public TextBlock getEpisodeSubHeading() {
        return episodeSubHeading;
    }

    public void setEpisodeSubHeading(TextBlock episodeSubHeading) {
        this.episodeSubHeading = episodeSubHeading;
    }

    public Image getEpisodeImage() {
        return episodeImage;
    }

    public void setEpisodeImage(Image episodeImage) {
        this.episodeImage = episodeImage;
    }

    public TextBlock getEpisodeLongDescription() {
        return episodeLongDescription;
    }

    public void setEpisodeLongDescription(TextBlock episodeLongDescription) {
        this.episodeLongDescription = episodeLongDescription;
    }

}
