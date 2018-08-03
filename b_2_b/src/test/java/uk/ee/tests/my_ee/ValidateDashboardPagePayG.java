package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;
@Test(groups = {"Regression"})
public class ValidateDashboardPagePayG extends BaseTest{

	@Autowired MyEELogic myEELogic;
	@Autowired UserRepository userRepository;
	   
	@DataProvider(name = "testUsers")
	public Object[][] getUsers() {
		return new Object[][] {
			{ "PAYG", userRepository.findById(4) },
			};
	    }
	    
	    @Test(dataProvider = "testUsers")
	    public void ViewCurrentCreditDashboard(String type,User user) {
	    	myEELogic.dashboardPagePayG(user);
	    }
	
}
