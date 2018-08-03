package uk.ee.framework.utils;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;


/**
 * Created by kiryl_zayets on 10/14/15.
 */
public class Waiter {
    private WebDriver webDriver;
    int waitElementTimeout = 40;

    public Waiter() {}

    public Waiter(WebDriver webDriver) {
        this.webDriver= webDriver;
    }


    public void waitElementReceiveWrongClick(){
        return;
    }

    public WebElement elementIsClickable(WebElement webElement) {
        new WebDriverWait(webDriver, waitElementTimeout).
                ignoring(NoSuchElementException.class,
                        ElementNotVisibleException.class).
                until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }


    public WebElement elementIsPresent(WebElement webElement) {
        new WebDriverWait(webDriver, waitElementTimeout).
                ignoreAll(Arrays.asList(
                        NoSuchElementException.class,
                        StaleElementReferenceException.class,
                        ElementNotVisibleException.class)).
                until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    public Boolean isPresent(WebElement webElement) {
        try {
            new WebDriverWait(webDriver, waitElementTimeout).
                    ignoring(NoSuchElementException.class,
                            ElementNotVisibleException.class).
                    until(ExpectedConditions.visibilityOf(webElement));
        } catch (WebDriverException e) {
            return false;
        }

        return true;
    }

    public WebElement elementVisible(WebElement webElement) {
        new WebDriverWait(webDriver, waitElementTimeout).
                ignoring(NoSuchElementException.class,
                        ElementNotVisibleException.class).
                until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    public void elementVisible(By by) {
        new WebDriverWait(webDriver, waitElementTimeout).
                ignoring(NoSuchElementException.class,
                        ElementNotVisibleException.class).
                until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public Boolean scrollToElement(WebElement webelement) {
    	JavascriptExecutor je = (JavascriptExecutor) webDriver;
		je.executeScript("arguments[0].scrollIntoView(true);", webelement);
		return webelement.isDisplayed();
    }


    public <T extends TypifiedElement> T waitStalenessOf(By by) {
        new WebDriverWait(webDriver, waitElementTimeout).until
                (ExpectedConditions
                        .stalenessOf(webDriver.findElement(by)));
        return (T) webDriver.findElement(by);
    }

    public WebElement waitStalenessOf(WebElement element) {
        new WebDriverWait(webDriver, waitElementTimeout).until
                (ExpectedConditions
                        .stalenessOf(element));
        return element;
    }

    /**
     * Method that waits for the alert to be present and then switches to it
     *
     * @return Alert - returns Alert object
     */
    public Alert waitAlert() {
        Alert alert = null;
        try {
            new WebDriverWait(webDriver, 5).
                    until(ExpectedConditions.alertIsPresent());
            alert = webDriver.switchTo().alert();
        } catch (TimeoutException e) {
//            logger.error("getPopupAlert() :: Alert could not be found.");
        }

        return alert;
    }

    public Waiter waitForLoad() {
        new WebDriverWait(webDriver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        return this;
    }
    
	public String loop(List<WebElement> ele) {
		int n = ele.size();
		for (int i=0; i< n ; i++){
		if (ele.get(i).isDisplayed()){
			System.out.println(ele.get(i));
			ele.get(i).click();	
			break;
			}
		}
		return "No Element";
	}
	
	 public void switchtoframe(WebElement webelement){
	        webDriver.switchTo().frame(webelement);
	 }
	 
	 public Boolean isClickable(WebElement webelement) {
			try {
				WebDriverWait wait = new WebDriverWait(webDriver, waitElementTimeout);
				wait.until(ExpectedConditions.elementToBeClickable(webelement));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	 
	    public void switchToActive(WebElement webelement) {
	    	webDriver.switchTo().defaultContent();
		}
	    
	    public void randomClick(List<WebElement> webelement) {
	        Random randomGenerator = new Random();
	        int randomIndex = randomGenerator.nextInt(webelement.size());
	        webelement.get(randomIndex).click();
		}
	    
	    public void displayButtonCheck(List<WebElement> webelement) {
	    	int n = webelement.size();
			for (int i=0; i<= n ; i++){
			if (webelement.get(i).isDisplayed()){
				webelement.get(i).click();
				break;
				}
			}
			
		}
	    
	    public static void switchToWindow(WebDriver d){
			Set<String> allWindowHandles = d.getWindowHandles();
			Iterator<String> it = allWindowHandles.iterator();
			while(it.hasNext())
			{
				d.switchTo().window(it.next());								
			}	
		}
	
}