package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;

@Test(groups = { "Regression" })
public class PaygManageCards extends BaseTest {
	@Autowired
	MyEELogic myEELogic;
	@Autowired
	UserRepository userRepository;

	@DataProvider(name = "testUsers")
	public Object[][] getUsers() {
		return new Object[][] { 
				{ "Pay as you go",userRepository.findById(8) }
		};
	}

	@Test(dataProvider = "testUsers")
	public void manageCards(String type, User user) {
		myEELogic.removeRegisteredCard(user);

	}

}
