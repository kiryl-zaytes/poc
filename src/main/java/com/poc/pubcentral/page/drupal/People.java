package com.poc.pubcentral.page.drupal;

import com.poc.pubcentral.bo.UserPojo;
import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.customcontrols.CustomButton;
import com.poc.pubcentral.page.Page;
import com.poc.pubcentral.page.drupal.block.AddUser;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by kiryl_zayets on 10/14/15.
 */
@Configuration
@Scope("prototype")
@PageMarker
public class People extends Page {

    AddUser userBlock;
    @FindBy(css = "div#block-seven-local-actions a[href$='create']")
    private CustomButton addUser;

    public void addUser(UserPojo userPojo) {
        addUser.click(webDriver);
        userBlock.addAdmin(userPojo);
    }
}
