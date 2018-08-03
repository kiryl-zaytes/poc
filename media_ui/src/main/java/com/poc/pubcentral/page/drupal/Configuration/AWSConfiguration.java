package com.poc.pubcentral.page.drupal.Configuration;

import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.page.Page;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/16/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class AWSConfiguration extends Page {

    @FindBy(css = "input#edit-aws-sqs-aws-key")
    TextInput accessKey;

    @FindBy(css = "input#edit-aws-sqs-aws-secret")
    TextInput secretKey;

    public void configure(String key, String secret) {
        accessKey.clear();
        secretKey.clear();
        accessKey.sendKeys(key);
        secretKey.sendKeys(secret);
        button.click();
        getStatusText();
    }
}
