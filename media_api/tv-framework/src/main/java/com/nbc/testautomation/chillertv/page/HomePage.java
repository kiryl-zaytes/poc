package com.nbc.testautomation.chillertv.page;

import com.nbc.testautomation.webdriver.element.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Page Object for Chiller TV Home Page
 */
@Component
@Scope("prototype")
public class HomePage extends BasePage {

    @FindBy(xpath = "//h1")
    private ExtendedWebElement title;

    @FindBy(id = "navbar")
    private HeaderMenuNavigationBlock headerMenuNavigationBlock;

    public HeaderMenuNavigationBlock getHeaderMenuNavigationBlock() {
        return headerMenuNavigationBlock;
    }

    public void setHeaderMenuNavigationBlock(HeaderMenuNavigationBlock headerMenuNavigationBlock) {
        this.headerMenuNavigationBlock = headerMenuNavigationBlock;
    }

    public ExtendedWebElement getTitle() {
        return title;
    }

    public void setTitle(ExtendedWebElement title) {
        this.title = title;
    }
}
