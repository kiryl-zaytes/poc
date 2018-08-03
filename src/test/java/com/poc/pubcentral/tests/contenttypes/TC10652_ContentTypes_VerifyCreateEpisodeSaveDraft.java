package com.poc.pubcentral.tests.contenttypes;

import com.poc.pubcentral.bo.EpisodePojo;
import com.poc.pubcentral.page.content.Episode;
import com.poc.pubcentral.tests.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nbcuni.test.webdriver.Utilities;

public class TC10652_ContentTypes_VerifyCreateEpisodeSaveDraft extends BaseTest {

	@Autowired Episode episode;


	@Test(groups = {"regression", "TC10652"})
	public void testTC10652(){
		EpisodePojo epPojo = dao.getById(EpisodePojo.class, 1);
		Utilities.logInfoMessage("Filling out Create Episode Form");
		episode.fillForm(epPojo);
		Utilities.logInfoMessage("Submitting form");
		String message = episode.saveAsDraft();
		Assert.assertEquals(
				"Status message\nEpisode " + epPojo.getTitle() +
                " has been created.", message);
		Utilities.logInfoMessage("Save as Draft successful!");
	}

}
