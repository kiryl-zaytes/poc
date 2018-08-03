package com.poc.pubcentral.page.content;

import com.poc.pubcentral.bo.BaseType;
import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.page.Page;
import com.poc.pubcentral.page.content.block.Operations;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by kiryl_zayets on 11/10/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class ContentList extends Page {

    Operations operations;

    @FindBy(css = "#block-base-pagetitle")
    HtmlElement messageTitle;

    public String delete(BaseType type){
        this.navigate(pageMapping.CONTENT);
        operations.delete(type.getTitle());
        waiter.isPresent(messageTitle);
        button.click();
        return getStatusText();
    }
}
