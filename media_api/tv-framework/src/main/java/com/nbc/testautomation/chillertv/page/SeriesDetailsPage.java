package com.nbc.testautomation.chillertv.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Series Page
 */
@Component
@Scope("prototype")
public class SeriesDetailsPage extends BasePage {

    public static final String PAGE_PATH_PATTERN = "series/%s";

    @FindBy(how = How.CLASS_NAME, using = "qa-series")
    private SeriesDetailsBlock seriesDetailsBlock;

    public SeriesDetailsBlock getSeriesDetailsBlock() {
        return seriesDetailsBlock;
    }

    public void navigate(String seriesId) {
        extendedWebDriver.navigate().to(
                environmentConfiguration.getApplicationUrl() + String.format(PAGE_PATH_PATTERN, seriesId));
    }

}
