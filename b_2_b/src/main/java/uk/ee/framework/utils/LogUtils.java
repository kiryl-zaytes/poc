package uk.ee.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import uk.ee.framework.post_processor.Loggable;

import java.io.File;


public class LogUtils {

    final String RP_MESSAGE = "RP_MESSAGE#FILE#%s#%s";
    WebDriver webDriver;
    @Loggable protected Logger logger;

    public void screenAndLog(String message) {
        File screen = ((TakesScreenshot) webDriver)
                .getScreenshotAs(OutputType.FILE);
        logger.warn(String.format(RP_MESSAGE, screen.getAbsolutePath(),
                message));
    }
}