package com.nbc.testautomation.chillertv.page;


import com.nbc.testautomation.webdriver.element.ExtendedWebElement;
import com.nbc.testautomation.webdriver.element.TextBlock;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Video Details Page
 * <p>
 * TODO move video details to block
 * TODO add class name to video player
 */
@Component
@Scope("prototype")
public class VideoDetailsPage extends BasePage {

    public static final String PAGE_PATH_PATTERN = "video/%s";

    @FindBy(className = "qa-video-title")
    protected TextBlock videoTitle;

    @FindBy(className = "qa-long-description")
    protected TextBlock videoLongDescription;

    @FindBy(xpath = "//*[@class='qa-video']//iframe")
    protected ExtendedWebElement video;

    public TextBlock getVideoTitle() {
        return videoTitle;
    }

    public TextBlock getVideoLongDescription() {
        return videoLongDescription;
    }

    public ExtendedWebElement getVideo() {
        return video;
    }

    public String getVideoSrc() {
        return video.getWrappedElement().getAttribute("src");
    }

    public void navigate(String videoId) {
        extendedWebDriver.navigate().to(
                environmentConfiguration.getApplicationUrl() + String.format(PAGE_PATH_PATTERN, videoId));
    }
}
