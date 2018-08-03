package com.poc.pubcentral.page.content;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

import com.poc.pubcentral.bo.ImagePojo;
import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.page.Page;
import com.nbcuni.test.lib.Util;
import com.nbcuni.test.webdriver.CustomWebDriver;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * This class has all the locators for the Create and Image page, also, modular methods to upload a file and fill out the form
 */

@Configuration
@Scope("prototype")
@PageMarker
public class Image extends Page {


    Util util;
    WebDriverWait wait;

    @FindBy(id = "edit-field-image-upload-0-upload")
    TextInput uploadButton;

    @FindBy(id = "edit-name-0-value")
    HtmlElement titleField;

    @FindBy(id = "edit-field-caption-0-value")
    HtmlElement captionField;

    @FindBy(id = "edit-field-description-0-value")
    HtmlElement descriptionField;

    @FindBy(id = "edit-field-categories-0-target-id")
    HtmlElement categoriesField;

    @FindBy(id = "edit-field-tags-0-target-id")
    HtmlElement tagsField;

    @FindBy(id = "edit-field-alt-0-value")
    HtmlElement altTextField;

    @FindBy(id = "edit-field-credit-0-value")
    HtmlElement creditField;

    @FindBy(id = "edit-field-copyright-0-value")
    HtmlElement copyrightField;

    @FindBy(id = "edit-field-source-0-value")
    HtmlElement sourceField;

    @FindBy(id = "edit-field-channel-reference-0-program-nid")
    Select seriesReference;

    @FindBy(id = "edit-field-channel-reference-0-season-nid")
    Select seasonReference;

    @FindBy(id = "edit-field-channel-reference-0-episode-nid")
    Select episodeReference;

    @FindBy(id = "edit-uid-0-target-id")
    HtmlElement publisherIdTextField;

    @FindBy(id = "edit-created-0-value-date")
    HtmlElement createdDateField;

    @FindBy(id = "edit-created-0-value-time")
    HtmlElement createdTimeField;

    @FindBy(id = "edit-cancel")
    HtmlElement cancelButton;

    @FindBy(id = "edit-submit")
    HtmlElement saveButton;

    @FindBy(name = "field_image_upload_0_remove_button")
    HtmlElement successfulUploadMsg;

    @FindBy(xpath = "//div[contains(@class, 'messages--error')]")
    HtmlElement uploadErrorContainer;

    @FindBy(id = "edit-field-high-res-value")
    HtmlElement hiResCheckbox;

    @FindBy(id = "edit-uid-0-target-id")
    HtmlElement publisher_id;

    @FindBy(id = "edit-created-0-value-date")
    HtmlElement create_date;

    @FindBy(id = "edit-created-0-value-time")
    HtmlElement create_time;

    /**
     * xpath locator for the image once it's been uploaded
     */
    public static final String IMAGE_LOCATOR_XPATH = "//img[contains(@src, '<image_name>')]";


  /**
   * Method that clicks on the 'choose file' button and uploads the image file based on the param
   *
   * @param imageName {@link String} Name of the image being uploaded
   */
    public void imageUpload(String imageName){
//    	uploadButton.click();
    	uploadButton.sendKeys(imageName);
    		if(!(imageName.contains(".jpg") || imageName.contains(".jpeg") || imageName.contains(".png") ||
    				imageName.contains(".gif"))){
    			//Verify that the image did not upload
                ((CustomWebDriver)webDriver).isVisible(uploadErrorContainer);
    		}
    		else{
                ((CustomWebDriver)webDriver).isVisible(successfulUploadMsg);
    		}

    }

    /**
     * Method that fills out the form in its entirety
     *
     * @param imagePojo {@link ImagePojo} ImagePojo object
     */
    public void create(ImagePojo imagePojo){
    	this.navigate(pageMapping.CREATE_IMAGE);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style" +
                        ".overflow='visible';",
                uploadButton);
        uploadButton.sendKeys(this.getClass().getClassLoader().getResource(
                "Images/" + imagePojo.getFileName()).getPath());
    	titleField.sendKeys(imagePojo.getTitle());
    	captionField.sendKeys(imagePojo.getCaption());
    	descriptionField.sendKeys(imagePojo.getDescription());
    	hiResCheckbox.click();
    	categoriesField.sendKeys(imagePojo.getCategories());
    	tagsField.sendKeys(imagePojo.getTags());
    	altTextField.sendKeys(imagePojo.getAltText());
    	creditField.sendKeys(imagePojo.getCredit());
    	copyrightField.sendKeys(imagePojo.getCopyright());
    	sourceField.sendKeys(imagePojo.getSource());
        seriesReference.selectByVisibleText(imagePojo.getSeries());
        seasonReference.selectByVisibleText(imagePojo.getSeason());
        episodeReference.selectByVisibleText(imagePojo.getEpisode());
        saveButton.click();
    }

    /**
     * Method that only deals with the "By" line of the form which is optional
     *
     */
    public void fillPublisherForm(){
    	ImagePojo imagePojo = new ImagePojo();
    	publisher_id.sendKeys(imagePojo.getPublisherId());
    	create_date.sendKeys(imagePojo.getCreateDate());
    	create_time.sendKeys(imagePojo.getCreateTime());
    }

    /**
     * Method that clicks on the save button on the form and then verifies that the image is saved
     *
     * @param imageName {@link String} Image name that is uploaded and needs to be verified
     */
    public void saveImage(CustomWebDriver driver, String imageName){
    	wait = new WebDriverWait(driver, 2);
    	ImagePojo imgPojo = new ImagePojo();
    	saveButton.click();
    	wait.until(ExpectedConditions.titleIs(imgPojo.getTitle()));
    	util.verifyObjectExists(By.xpath(IMAGE_LOCATOR_XPATH.replace("<image_name>", imageName)));
    }

    /**
     * Method that either accepts the popup alert that appears after hitting "cancel" button based on the param
     *
     * @param acceptOrCancel {@link String} Pass 'Accept' if pressing 'ok'. Pass "Cancel" if pressing 'cancel' on the popup alert.
     */
    public void clickCancelButton(CustomWebDriver driver, String acceptOrCancel){
    	wait = new WebDriverWait(driver, 2);
    	cancelButton.click();
    	wait.until(ExpectedConditions.alertIsPresent());
    	acceptOrCancelAlert(acceptOrCancel);
    }

    public String getReferenceNodes(){
        return waiter.elementIsPresent(channelReference).getText();
    }
}
