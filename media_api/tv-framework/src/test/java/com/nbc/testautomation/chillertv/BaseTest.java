package com.nbc.testautomation.chillertv;

import com.nbc.testautomation.chillertv.data.VideoRepository;
import com.nbc.testautomation.chillertv.data.EventRepository;
import com.nbc.testautomation.chillertv.data.SeasonRepository;
import com.nbc.testautomation.chillertv.data.SeriesRepository;
import com.nbc.testautomation.chillertv.data.EpisodeRepository;
import com.nbc.testautomation.chillertv.support.configuration.EnvironmentConfiguration;
import com.nbc.testautomation.chillertv.service.episode.EpisodeService;
import com.nbc.testautomation.chillertv.service.EventService;
import com.nbc.testautomation.chillertv.service.SeasonService;
import com.nbc.testautomation.chillertv.service.video.VideoService;
import com.nbc.testautomation.chillertv.service.series.SeriesService;
import com.nbc.testautomation.saucelabs.AbstractSauceLabsTest;
import com.nbc.testautomation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.AfterClass;

/**
 * Base test class which should be inherited by all test classes. It contains Web Driver instance which is accessible
 * for all descendants and configuration stuff.
 */
@ContextConfiguration(locations = {"classpath:" + BaseTest.CONFIGURATION_FILE})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BaseTest extends AbstractSauceLabsTest {

    public static final String CONFIGURATION_FILE = "configuration.xml";

    @Autowired
    protected DesiredCapabilities desiredCapabilities;

    @Autowired
    protected ExtendedWebDriver extendedWebDriver;

    @Autowired
    protected EnvironmentConfiguration environmentConfiguration;

    @Autowired
    protected VideoRepository videoRepository;

    @Autowired
    protected SeriesRepository seriesRepository;

    @Autowired
    protected EpisodeRepository episodeRepository;

    @Autowired
    protected VideoService videoUiService;

    @Autowired
    protected VideoService videoApiService;

    @Autowired
    protected EventRepository eventRepository;

    @Autowired
    protected EventService eventUiService;

    @Autowired
    protected EventService eventApiService;

    @Autowired
    protected SeasonRepository seasonRepository;

    @Autowired
    protected SeasonService seasonUiService;

    @Autowired
    protected SeasonService seasonApiService;

    @Autowired
    protected SeriesService seriesUiService;

    @Autowired
    protected SeriesService seriesApiService;

    @Autowired
    protected EpisodeService episodeUiService;

    @Autowired
    protected EpisodeService episodeApiService;

    @Override
    public WebDriver getWebDriver() {
        return extendedWebDriver.getWrappedDriver();
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser() {
        extendedWebDriver.quit();
    }
}
