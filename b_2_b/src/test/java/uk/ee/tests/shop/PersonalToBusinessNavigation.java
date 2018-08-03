package uk.ee.tests.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.ShopLogic;
import uk.ee.tests.base.BaseTest;

/**
 * Created by prabhu_s on 07/01/16.
 */
@Test(groups = { "Regression" })
public class PersonalToBusinessNavigation extends BaseTest{

	@Autowired
	ShopLogic shopLogic;
	
	public void PersonalToBusiness(){
		shopLogic.PersonalToBusiness();
	}
	
}
