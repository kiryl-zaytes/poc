package com.poc.pubcentral.tests.contenttypes;

import com.poc.pubcentral.bo.EpisodePojo;
import com.poc.pubcentral.page.content.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.poc.pubcentral.tests.base.BaseTest;
import com.nbcuni.test.webdriver.Utilities;

public class TC10780_ContentTypes_VerifyCreateEpisodePublish extends BaseTest {

@Autowired Episode episode;


	@Test(groups = {"regression", "TC10780"})
	public void testTC10652(){
		EpisodePojo epPojo = dao.getById(EpisodePojo.class, 1);
		Utilities.logInfoMessage("Filling out Create Episode Form");
		episode.fillForm(epPojo);
		Utilities.logInfoMessage("Submitting form");
		String message = episode.publishContent();
		Assert.assertEquals(
				"Status message\nEpisode " + epPojo.getTitle() +
                " has been created.", message);
		Utilities.logInfoMessage("Publish successful!");
	}
}
