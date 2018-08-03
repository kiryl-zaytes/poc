package com.poc.pubcentral.page;

import javax.annotation.PostConstruct;

import com.poc.pubcentral.common.driver.annotations.Loggable;
import com.poc.pubcentral.common.driver.configuration.SeleniumContext;
import com.poc.pubcentral.customcontrols.CustomButton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ch.qos.logback.classic.Logger;

import com.poc.pubcentral.utils.Waiter;
//import com.nbcuni.test.webdriver.CustomWebDriver;
//import com.nbcuni.test.webdriver.CustomWebDriverExceptionListener;


/**
 * Created by kiryl_zayets on 9/13/15.
 */

public class Page {

    final String RP_MESSAGE = "RP_MESSAGE#FILE#%s#%s";
    protected WebDriver webDriver;

    @Autowired protected PageMapping pageMapping;
    @Autowired @Qualifier(value = "uniqueLaunchId") protected String uniqueId;
    @Loggable protected Logger logger;

    protected Waiter waiter;

    @FindBy(css = "#edit-submit")
    protected CustomButton button;

    @FindBy(css = ".messages.messages--status")
    protected WebElement statusMessage;

    @FindBy(css = "div.field--type-channel-reference div.field__item")
    protected HtmlElement channelReference;

    @Autowired
    SeleniumContext context;

    @Value("${wait.element}")
    int waitElementTimeout;

    private String siteURL = null;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new HtmlElementDecorator(webDriver), this);
    }

    public Page() {}

    @PostConstruct
    public void init() {
        webDriver = context.getDriver();
        waiter = new Waiter(webDriver, waitElementTimeout);
    }

    public String getStatusText() {
        String text = "";
        try {
            text = waiter.elementVisible(statusMessage).getText();
        } catch (TimeoutException e) {
            logger.error("Problem arisen!! Expected text is not found so form" +
                    " might be saved incorrectly!");
            logger.error(webDriver.getPageSource());
        }
        return text;
    }

    public String getCurrentLocation() {
        return webDriver.getCurrentUrl();
    }

    public Page navigate(String url) {
        webDriver.get(url);
        return this;
    }

    /**
     * Method that waits for the alert to be present and then switches to it
     * @return Alert - returns Alert object
     */
    public Alert getPopupAlert(){
    	Alert alert = null;
    	try{
    		WebDriverWait wait = new WebDriverWait(webDriver, 5);
    		wait.until(ExpectedConditions.alertIsPresent());
    		alert = webDriver.switchTo().alert();
    	}catch (TimeoutException e){
    		logger.error("getPopupAlert() :: Alert could not be found.");
    	}
    	return alert;
    }

    /**
     * Method that either clicks OK or Cancel on the alert menu.
     * @param okOrCancel {@link String} Params can only be either Ok or Cancel.
     */
    public void acceptOrCancelAlert(String okOrCancel){
    	if (okOrCancel.equalsIgnoreCase("ok")){
    		getPopupAlert().accept();
    	}else if(okOrCancel.equalsIgnoreCase("cancel")){
    		getPopupAlert().dismiss();
    	}
    	else{
    		logger.error("acceptOrCancelAlert() :: Error occured while using method, please check parameters passed.");
    	}
    }

    public String getNodeId(){
        String[] piecesofUrl = webDriver.getCurrentUrl().split("/");
        String id = piecesofUrl[piecesofUrl.length-1];
        return id;
    }

    public String getChannelReferenceSuquence(){
        return channelReference.getText().replace("»", "").replaceAll("\\s+","");
    }

//    protected WebElement elementIsPresent(WebElement webElement) {
//        new WebDriverWait(webDriver, waitElementTimeout).
//                ignoring(NoSuchElementException.class,
//                        ElementNotVisibleException.class).
//                until(ExpectedConditions.visibilityOf(webElement));
//        return webElement;
//    }
//
//    protected Boolean isPresent(WebElement webElement) {
//        try {
//            new WebDriverWait(webDriver, waitElementTimeout).
//                    ignoring(NoSuchElementException.class,
//                            ElementNotVisibleException.class).
//                    until(ExpectedConditions.visibilityOf(webElement));
//        } catch (WebDriverException e) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public WebElement elementVisible(WebElement webElement) {
//        new WebDriverWait(webDriver, waitElementTimeout).
//                ignoring(NoSuchElementException.class,
//                        ElementNotVisibleException.class).
//                until(ExpectedConditions.visibilityOf(webElement));
//
//        return webElement;
//    }

    public void submitForm(WebElement form) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].submit()" +
                ";", form);
    }

}
