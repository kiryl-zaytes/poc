package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.Payment;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;

/**
 * Created by anuj_dasari on 5/24/16.
 * 
 * Modified by prabhu_s on 08/02/16.
 */

@Test(groups = { "Regression" })
public class ValidatePaygTopUpHistory extends BaseTest {

	@Autowired
	MyEELogic myEELogic;
	@Autowired
	UserRepository userRepository;

	@DataProvider(name = "testUsers")
	public Object[][] getUsers() {
		return new Object[][] { { "Pay as you go",userRepository.findById(4) }

		};
	}

	@Test(dataProvider = "testUsers")
	public void topUpHistory(String type, User user) {
		String topUpHistoryDetail = myEELogic.viewTopUpHistory(user);
		System.out.println(topUpHistoryDetail);
	}
}