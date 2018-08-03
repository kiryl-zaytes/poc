package com.nbc.testautomation.chillertv.page;

import com.nbc.testautomation.webdriver.element.HtmlElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.htmlelements.element.Image;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * Block for representing episode details
 */
public class EpisodeDetailsThumbnailBlock extends HtmlElement {

    @FindBy(how = How.CLASS_NAME, using = "qa-episode-thumbnail-image")
    protected Image episodeImage;

    @FindBy(how = How.CLASS_NAME, using = "qa-short-description")
    protected TextBlock episodeShortDescriptions;

    @FindBy(how = How.CLASS_NAME, using = "qa-episode-thumbnail-title")
    protected TextBlock episodeTitle;

    public Image getEpisodeImage() {
        return episodeImage;
    }

    public TextBlock getEpisodeShortDescriptions() {
        return episodeShortDescriptions;
    }

    public TextBlock getEpisodeTitle() {
        return episodeTitle;
    }
}
