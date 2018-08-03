package com.poc.pubcentral.page.content;

import com.poc.pubcentral.bo.SeasonPojo;
import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.customcontrols.CustomButton;
import com.poc.pubcentral.page.Page;
import com.poc.pubcentral.page.content.block.BasicInfo;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by kiryl_zayets on 10/27/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Season extends Page {
    BasicInfo basicInfo;

    @FindBy(css = "#edit-field-series-0-target-id")
    TextInput series;

    @FindBy(css = "#edit-field-event-0-target-id")
    TextInput event;

    @FindBy(css = "#edit-field-production-number-0-value")
    TextInput productionNumber;

    @FindBy(css = "#edit-field-season-number-0-value")
    TextInput seasonNumber;

    @FindBy(css = "#edit-field-season-date-0-value-date")
    TextInput date;

    @FindBy(css = "#edit-field-program-reference-0-program-nid")
    Select reference;

    @FindBy(css = "#edit-actions input[type='submit']")
    CustomButton submit;

    public String create(SeasonPojo season) {
        this.navigate(pageMapping.CREATE_SEASON);
        basicInfo.fill(season);
        productionNumber.sendKeys(String.valueOf(season.getProductionNumber()));
        seasonNumber.sendKeys(String.valueOf(season.getSeasonNumber()));
        date.sendKeys(season.getSeasonDate());
        reference.selectByVisibleText(season.getProgramReference());
        submit.click();
        return getStatusText();
    }

    public String update(SeasonPojo season) {
        return getStatusText();
    }

}
