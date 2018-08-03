package com.poc.pubcentral.tests.base;

import ch.qos.logback.classic.Logger;
import com.poc.pubcentral.bo.UserPojo;
import com.poc.pubcentral.bo.dao.DAO;
import com.poc.pubcentral.common.driver.annotations.Loggable;
import com.poc.pubcentral.common.driver.configuration.AbstractCustomContext;
import com.poc.pubcentral.common.driver.listeners.SeleniumTestListener;
import com.poc.pubcentral.page.Login;
import com.poc.pubcentral.page.PageMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestExecutionListeners;
import org.testng.annotations.BeforeClass;

/**
 * Base test to carry general properties and objects.
 */

@TestExecutionListeners(SeleniumTestListener.class)
public class BaseTest extends AbstractCustomContext {

    @Autowired protected Login loginPage;
    @Autowired protected PageMapping pageMapping;
    @Autowired protected UserPojo admin;
    @Loggable protected Logger logger;
    @Autowired protected DAO dao;

    @Autowired @Qualifier(value = "uniqueLaunchId") protected String uniqueId;

    @Autowired
    @Value("${wait.element}")
    protected String timeout;

    @Value("${user.pubcentral}")
    protected String user;

    @Value("${user.pass}")
    protected String password;

    @Value("${sauce.user}")
    protected String sauceUser;

    @Value("${sauce.key}")
    protected String saucePass;

    @Value("${app.url}")
    protected String env;

    @BeforeClass(alwaysRun = true)
    public void login() {
        ((Login) loginPage.navigate(pageMapping.LOGIN))
                .login(admin);
    }
}

