package com.poc.pubcentral.utils;

import com.poc.pubcentral.common.driver.annotations.Loggable;
import com.poc.pubcentral.common.driver.configuration.SeleniumContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * Created by kiryl_zayets on 10/29/15.
 */
@Configuration
public class LogUtils {

    final String RP_MESSAGE = "RP_MESSAGE#FILE#%s#%s";

    @Autowired public SeleniumContext context;
    @Loggable protected Logger logger;
    protected Logger logger2;

    public void screenAndLog(String message) {
        File screen = ((TakesScreenshot) context.getDriver())
                .getScreenshotAs(OutputType.FILE);
        logger.warn(String.format(RP_MESSAGE, screen.getAbsolutePath(),
                message));
    }
}
