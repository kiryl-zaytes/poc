package com.nbc.testautomation.chillertv.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Season Details Page
 */
@Component
@Scope("prototype")
public class SeasonDetailsPage extends BasePage {

    public static final String PAGE_PATH_PATTERN = "series/%s/seasons/%s";

    @FindBy(how = How.CLASS_NAME, using = "qa-season")
    protected SeasonDetailsBlock seasonDetailsBlock;

    public SeasonDetailsBlock getSeasonDetailsBlock() {
        return seasonDetailsBlock;
    }

    public void navigate(String seasonId, String seriesId) {
        extendedWebDriver.navigate().to(
                environmentConfiguration.getApplicationUrl() + String.format(PAGE_PATH_PATTERN, seriesId, seasonId));
    }

}
