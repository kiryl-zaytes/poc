package com.poc.pubcentral.page;

import com.poc.pubcentral.common.driver.annotations.PageMarker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by kiryl_zayets on 9/13/15.
 */
@Configuration
@Scope("prototype")
@PageMarker
public class Main extends Page {

    @FindBy(css = "#toolbar-item-user")
    WebElement activeUser;

    public String getActiveUser() {
        return activeUser.getText();
    }

}
