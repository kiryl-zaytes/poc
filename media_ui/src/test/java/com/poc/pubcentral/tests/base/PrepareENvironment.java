package com.poc.pubcentral.tests.base;

import com.poc.pubcentral.bo.UserPojo;
import com.poc.pubcentral.constant.Messages;
import com.poc.pubcentral.page.Login;
import com.poc.pubcentral.page.drupal.Configuration.Import;
import com.poc.pubcentral.page.drupal.Extend;
import com.poc.pubcentral.page.drupal.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kiryl_zayets on 10/14/15.
 */
public class PrepareENvironment extends BaseTest {

    @Value("${sso.config.path}") public String ssoConfigPath;
    @Value("${sso.config.name}") public String ssoConfigName;
    @Value("${sso.user}") public String ssoUser;
    @Value("${sso.password}") public String ssoPassword;
    @Autowired Extend extendPage;
    @Autowired Import importPage;
    @Autowired People people;

    @Test
    public void prepareEnv() {
        ((Login) loginPage.navigate(pageMapping.LOGIN)).login(admin);
        loginPage.navigate(pageMapping.ADD_PEOPLE);
        people.addUser(new UserPojo(ssoUser, ssoPassword));
        loginPage.navigate(pageMapping.EXTEND);
        String text = extendPage.installModule("Pubcentral", "pc sso");

        Assert.assertTrue(text.contains("2 modules have been enabled:"));
        loginPage.navigate(pageMapping.SINGLE_IMPORT);
        String message = importPage.importConfigiration(ssoConfigPath,
                ssoConfigName);

        Assert.assertTrue(message.equals(String.format(Messages
                        .CONFIG_IMPORTED, ssoConfigName)),
                "Check configuration is imported \n" + message + "\n");
    }
}
