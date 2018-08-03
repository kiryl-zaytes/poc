package com.nbc.testautomation.chillertv;

import com.nbc.testautomation.chillertv.page.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Sample test class which just clicks 'Event' menu item
 */
public class SampleChillerTvTest extends BaseTest {

    @Autowired
    protected HomePage homePage;

    @BeforeClass
    public void startBrowser() {
        extendedWebDriver.get(environmentConfiguration.getApplicationUrl());
    }

    @Test
    public void clickEventsMenuLink() {
        homePage.getHeaderMenuNavigationBlock().getEventLink().click();
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser() {
        extendedWebDriver.quit();
    }
}
