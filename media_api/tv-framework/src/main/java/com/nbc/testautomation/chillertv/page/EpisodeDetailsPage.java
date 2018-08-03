package com.nbc.testautomation.chillertv.page;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Episode Page
 */
@Component
@Scope("prototype")
public class EpisodeDetailsPage extends BasePage {

    public static final String PAGE_PATH_PATTERN = "series/%s/episodes/%s";

    @FindBy(how = How.CLASS_NAME, using = "qa-episode")
    private EpisodeDetailsBlock episodeDetailsBlock;

    public EpisodeDetailsBlock getEpisodeDetailsBlock() {
        return episodeDetailsBlock;
    }

    public void navigate(String episodeId, String seriesId) {
        extendedWebDriver.navigate().to(
                environmentConfiguration.getApplicationUrl() + String.format(PAGE_PATH_PATTERN, seriesId, episodeId));
    }
}
