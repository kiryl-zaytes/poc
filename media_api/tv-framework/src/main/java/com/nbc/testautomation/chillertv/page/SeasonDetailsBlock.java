package com.nbc.testautomation.chillertv.page;

import com.nbc.testautomation.webdriver.element.HtmlElement;
import com.nbc.testautomation.webdriver.element.TextBlock;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Block for representing season page details
 */
public class SeasonDetailsBlock extends HtmlElement {

    @FindBy(how = How.CLASS_NAME, using = "qa-season-title")
    private TextBlock seasonTitle;

    @FindBy(xpath = ".//*[contains(@class, 'qa-episode-thumbnail-container')]")
    protected List<EpisodeDetailsThumbnailBlock> episodeDetailsThumbnailBlock;

    public TextBlock getSeasonTitle() {
        return seasonTitle;
    }

    public List<EpisodeDetailsThumbnailBlock> getEpisodeDetailsThumbnailBlock() {
        return episodeDetailsThumbnailBlock;
    }

}
