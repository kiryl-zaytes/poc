package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;

/**
 * Created by prabhu_S on 6/1/16.
 * 
 * Modified by Syamphaneendra kalluri on 08/03/16.
 * 
 * This class is used to automate the PurchasePayGPacks scenario.
 */
@Test(groups = { "Regression" })
public class PurchasePayGPacks extends BaseTest {

	@Autowired
	MyEELogic myEELogic;
	@Autowired
	UserRepository userRepository;

	@DataProvider(name = "testUsers")
	public Object[][] getUsers() {
		return new Object[][] { { userRepository.findById(8), "Existing" }, };
	}

	@Test(dataProvider = "testUsers")
	public void purchasePacks(User user, String type) {
		myEELogic.purchasePayGPacks(user);
	}

}
