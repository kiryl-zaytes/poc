package com.poc.pubcentral.page.content;

import com.poc.pubcentral.bo.EpisodePojo;
import com.poc.pubcentral.page.content.block.BasicInfo;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.customcontrols.CustomButton;
import com.poc.pubcentral.page.Page;

/**
 * Created by kiryl_zayets on 10/26/15.
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Episode extends Page {

    BasicInfo basicInfo;

    @FindBy(css = "#edit-field-program-reference-0-program-nid")
    Select programReference;

    @FindBy(css = "#edit-field-program-reference-0-season-nid")
    Select seasonReference;

    @FindBy(css = "#edit-field-episode-type")
    Select episodeType;

    @FindBy(css = "#edit-field-episode-number-0-value")
    TextInput episodeNumber;

    @FindBy(css = "#edit-field-rating")
    Select tvRating;

    @FindBy(css = "#edit-field-supplementary-airing-0-value-date")
    TextInput supplementaryAiring ;

    @FindBy(css = "#edit-actions input[type='submit']")
    CustomButton submit;

    @FindBy(css = "#edit-field-production-number-0-value")
    TextInput prodNumber;

    @FindBy(xpath = "//input[@name='op'][@value='Save as draft']")
    CustomButton saveAsDraft;

    @FindBy(css = "#edit-cancel")
    HtmlElement cancel;

    public String create(EpisodePojo episode) {
        this.navigate(pageMapping.CREATE_EPISODE);
        basicInfo.fill(episode);
        programReference.selectByVisibleText(episode.getSeriesReference());
        seasonReference.selectByVisibleText(episode.getSeasonReference());
        episodeType.selectByVisibleText(episode.getEpisodeType());
        episodeNumber.sendKeys(episode.getEpisodeNumber());
        tvRating.selectByVisibleText(episode.getTvRating());
        submit.click();
        return getStatusText();
    }

    /**
     * Method which fills out all the form fields on the Episode Page.
     * @param episodePojo
     * @return {@link String} Status Text once the Episode is created
     */
    public void fillForm(EpisodePojo episodePojo) {
        this.navigate(pageMapping.CREATE_EPISODE);
        basicInfo.fill(episodePojo);
        programReference.selectByVisibleText(episodePojo.getSeriesReference());
        seasonReference.selectByVisibleText(episodePojo.getSeasonReference());
        episodeType.selectByVisibleText(episodePojo.getEpisodeType());
        episodeNumber.sendKeys(episodePojo.getEpisodeNumber());
        tvRating.selectByVisibleText(episodePojo.getTvRating());
    }

    /**
     * Method that clicks on Publish button and gets status text
     * @return {@link String} Status text
     */
    public String publishContent() {
    	submit.click();
        return getStatusText();
    }

    /**
     * Method that click on Save as Draft button and gets status text
     * @return {@link String} Status text
     */
    public String saveAsDraft(){
    	saveAsDraft.click();
    	return getStatusText();
    }

    /**
     * Method that clicks on the cancel button and based on the param either accepts the alert or dismiss it.
     *
     * @param okOrCancel {@link String} If alert needs to be accepted pass Ok, if needs to be dismissed passed Cancel.
     */
    public void clickCancel(String okOrCancel){
    	WebDriverWait wait = new WebDriverWait(webDriver, 3);
    	cancel.click();
    	wait.until(ExpectedConditions.alertIsPresent());
    	acceptOrCancelAlert(okOrCancel);
    }
}
