package com.poc.pubcentral.tests.contenttypes;

import java.io.File;

import com.poc.pubcentral.page.content.Image;
import org.openqa.selenium.remote.LocalFileDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.poc.pubcentral.bo.ImagePojo;
import com.poc.pubcentral.tests.base.BaseTest;
import com.nbcuni.test.webdriver.CustomWebDriver;

public class CreateImage extends BaseTest {

	@Autowired Image image;
	CustomWebDriver driver;

	@Test(groups = {"regression", "createImage"})
	public void testImageUpload(){
		String imageFilePath = "./src/test/resources/Images/";
		driver = new CustomWebDriver();

		ImagePojo imgPojo = dao.getById(ImagePojo.class, 1);
		//Detects whether the test is being run locally or in a grid/cloud
		driver.setFileDetector(new LocalFileDetector());
		//path to the directory where image files are saved
    	File imageDirectory = new File(imageFilePath);
    	String[] listOfImages = imageDirectory.list();
    	//Iterate through the list of images in the folder and try uploading them each at a time.
//    	for(int i = 0; i < listOfImages.length; i++){
//    		image.create(driver, imgPojo, listOfImages[i]);
//    		image.saveImage(driver, listOfImages[i]);
//    	}
	}
}
