package com.poc.pubcentral.common.driver.listeners;

import com.poc.pubcentral.common.driver.annotations.MethodParallezationSupported;


import org.openqa.selenium.WebDriver;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by kiryl_zayets on 6/29/15.
 */
public class SeleniumTestListener extends AbstractTestExecutionListener {

    private String browser;
    private String suite;
    private MethodParallezationSupported supported;

    @Override
    public void beforeTestClass(TestContext testContext) throws
            ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, IOException,
            SAXException, ParserConfigurationException {
        this.getClass().getClassLoader().loadClass("org.slf4j.LoggerFactory").
                getMethod("getLogger", ClassLoader.getSystemClassLoader()
                        .loadClass("java.lang.String")).invoke(null, "ROOT");
        suite = System.getProperty("suite");
        browser = System.getProperty("browser");
        SimpleThreadScope simpleThreadScope = (SimpleThreadScope)
                testContext.getApplicationContext().getBean
                        ("simpleThreadScope");
        simpleThreadScope.remove("webDriver");
//        this.isMethodParallezationSupported(testContext, false);
    }

//    @Override
//    public void beforeTestMethod(TestContext testContext) {
//        this.isMethodParallezationSupported(testContext, true);
//    }
//
//    @Override
//    public void afterTestMethod(TestContext testContext) {
////        if (supported != null) {
////            testContext.getApplicationContext().getBean(WebDriver.class)
//// .quit();
////        }
//    }

    @Override
    public void afterTestClass(TestContext testContext) {
        testContext.getApplicationContext().getBean(WebDriver.class).quit();
    }

    private void isMethodParallezationSupported(TestContext testContext,
            boolean supported) {
        MethodParallezationSupported methodParallezation = testContext
                .getTestClass().getDeclaredAnnotation
                        (MethodParallezationSupported.class);
        if ((methodParallezation == null && supported == false) ||
                (methodParallezation != null && supported == true)) {
            SimpleThreadScope simpleThreadScope = (SimpleThreadScope)
                    testContext.getApplicationContext().getBean
                            ("simpleThreadScope");
            simpleThreadScope.remove("webDriver");
        }
    }
}
