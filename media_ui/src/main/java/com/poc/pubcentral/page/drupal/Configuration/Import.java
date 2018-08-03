package com.poc.pubcentral.page.drupal.Configuration;

import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.page.Page;
import com.poc.pubcentral.utils.FileUtils;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/13/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Import extends Page {

    @FindBy(css = "#edit-config-type")
    Select configType;

    @FindBy(css = "#edit-import")
    TextInput editImport;

    @FindBy(css = "#edit-config-name")
    private TextInput configurationName;

    public String importConfigiration(String configurationPath,
            String configName) {
        String config = FileUtils.readFile(configurationPath);
        configType.selectByVisibleText("Simple configuration");
        editImport.sendKeys(config);
        configurationName.sendKeys(configName);
        button.click(webDriver);
        button.click(webDriver);
        return getStatusText();
    }
}
