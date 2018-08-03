package com.poc.pubcentral.page.content;

import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.customcontrols.CustomButton;
import com.poc.pubcentral.page.Page;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/17/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Article extends Page {

    @FindBy(css = "#edit-title-0-value")
    TextInput title;

    @FindBy(css = "body.cke_editable.cke_editable_themed.cke_contents_ltr" +
            ".cke_show_borders")
    TextInput body;

    @FindBy(css = "iframe.cke_wysiwyg_frame.cke_reset")
    HtmlElement iframe;

    @FindBy(css = "#edit-actions input[type='submit']")
    CustomButton submit;

    public String create(com.poc.pubcentral.bo.Article article) {
        title.sendKeys(article.getTitle());
        webDriver.switchTo().frame(iframe);
        body.sendKeys(article.getBody());
        webDriver.switchTo().defaultContent();
        submit.click();
        return getStatusText();
    }

}
