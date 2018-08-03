package com.poc.pubcentral.page;

import com.poc.pubcentral.block.LoginBlock;
import com.poc.pubcentral.bo.UserPojo;
import com.poc.pubcentral.common.driver.annotations.PageMarker;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by kiryl_zayets on 9/13/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Login extends Page {

    private LoginBlock loginBlock;

    public Login login(UserPojo userPojo) {
        loginBlock.login(userPojo, webDriver);
        return this;
    }
}
