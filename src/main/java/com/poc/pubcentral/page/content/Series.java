package com.poc.pubcentral.page.content;

import com.poc.pubcentral.bo.SeriesPojo;
import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.customcontrols.CustomButton;
import com.poc.pubcentral.page.Page;
import com.poc.pubcentral.page.content.block.BasicInfo;
import com.poc.pubcentral.page.content.block.MediaInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by kiryl_zayets on 10/12/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Series extends Page {

    BasicInfo basicInfo;
    MediaInfo mediaInfo;

    @FindBy(css = "#edit-field-series-type")
    HtmlElement type;

    @FindBy(css = "#edit-actions input[type='submit']")
    CustomButton submit;

    public String create(SeriesPojo seriesPojo) {
        this.navigate(pageMapping.CREATE_SERIES);
        basicInfo.fill(seriesPojo);
        mediaInfo.fill(seriesPojo);
        selectValue(seriesPojo.getSeriesType());
        submit.click();
        return getStatusText();
    }

    private void selectValue(String value) {
        List<WebElement> options = type.findElements(By.cssSelector("div"));
        for (WebElement opt : options) {
            if (opt.getText().equals(value)) {
                opt.findElement(By.cssSelector("input")).click();
                break;
            }
        }
    }
}
