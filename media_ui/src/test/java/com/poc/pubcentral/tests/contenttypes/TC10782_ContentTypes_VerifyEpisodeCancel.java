package com.poc.pubcentral.tests.contenttypes;

import com.poc.pubcentral.bo.EpisodePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.poc.pubcentral.page.content.Episode;
import com.poc.pubcentral.tests.base.BaseTest;
import com.nbcuni.test.webdriver.CustomWebDriver;
import com.nbcuni.test.webdriver.Utilities;

public class TC10782_ContentTypes_VerifyEpisodeCancel extends BaseTest {

	@Autowired Episode episode;
	CustomWebDriver driver;
	private final String Title_Home = "admin | PubCentral";
	private final String Title_Episode = "Create Episode | PubCentral";

	@Test(groups = {"regression", "TC10780"})
	public void testTC10652(){
		driver = new CustomWebDriver();
		EpisodePojo epPojo = dao.getById(EpisodePojo.class, 1);
		Utilities.logInfoMessage("Filling out Create Episode Form");
		episode.fillForm(epPojo);
		Utilities.logInfoMessage("Submitting form");
		episode.clickCancel("cancel");
		String title = driver.getTitle();
		Assert.assertEquals(title, Title_Episode);
		episode.clickCancel("ok");
		title = driver.getTitle();
		Assert.assertEquals(title, Title_Home);
		Utilities.logInfoMessage("Cancel operation successfull");
	}

}
