package com.poc.pubcentral.tests.login;

import com.poc.pubcentral.bo.UserPojo;
import com.poc.pubcentral.page.Login;
import com.poc.pubcentral.page.Main;
import com.poc.pubcentral.page.PageMapping;
import com.poc.pubcentral.page.drupal.Configuration.Import;
import com.poc.pubcentral.page.drupal.Extend;
import com.poc.pubcentral.page.drupal.People;
import com.poc.pubcentral.tests.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by kiryl_zayets on 9/10/15.
 */

public class VerifyLogin extends BaseTest {

    @Value("${sso.config.path}") public String ssoConfigPath;
    @Value("${sso.config.name}") public String ssoConfigName;
    @Value("${sso.user}") public String ssoUser;
    @Value("${sso.password}") public String ssoPassword;
    @Autowired Login loginPage;
    @Autowired Main mainPage;
    @Autowired Extend extendPage;
    @Autowired Import importPage;
    @Autowired UserPojo admin;
    @Autowired PageMapping pageMapping;
    @Autowired People people;

    @Test(description = "When a user is not logged in and visits any page " +
            "they get redirected to “/login\" splash page",
          groups = {"smoke", "regression", "login", "sso"})
    public void checkRedirect() {
        loginPage.navigate(pageMapping.USER);
        Assert.assertTrue(loginPage.getCurrentLocation().contains("/login"));
    }

    @Test(groups = {"login", "smoke", "regression"})
    public void login() {
        ((Login) loginPage.navigate(pageMapping.LOGIN))
                .login(admin);
        String userName = mainPage.getActiveUser();
        Assert.assertTrue(userName.equals(admin.getUser()), "Verify user is " +
                "logged in");
    }
}
