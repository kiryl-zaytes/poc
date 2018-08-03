package com.poc.pubcentral.tests.taxonomy;

import com.poc.pubcentral.page.drupal.Configuration.Taxonomy;
import com.poc.pubcentral.tests.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kiryl_zayets on 10/15/15.
 */
public class CreateTaxonomy extends BaseTest {

    String name = "AutomationTaxonomy";
    String desc = "AutomationTaxonomyDescription";
    String updatedName = "AutomationTaxonomyUpd";

    @Autowired Taxonomy taxonomy;

    @Test(groups = "taxonomy")
    public void taxonomyManipulations() {
        taxonomy.navigate(pageMapping.TAXONOMY);
        String message = taxonomy.add(name, desc, uniqueId);
        Assert.assertEquals("Status message\nCreated new vocabulary " + name +
                ".", message);
        taxonomy.navigate(pageMapping.TAXONOMY);
        message = taxonomy.update(name, updatedName);
        Assert.assertEquals("Status message\nThe configuration options have " +
                "been saved.", message);
        taxonomy.navigate(pageMapping.TAXONOMY);
        message = taxonomy.delete(updatedName);
        Assert.assertEquals(
                "Status message\nDeleted vocabulary " + updatedName +
                        ".", message);
    }
}
