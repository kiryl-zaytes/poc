package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;
/**
 * Created by prabhu_S on 6/03/16.
 */

@Test(groups = {"Regression"})
public class UpdateGroupUsageControlSharer extends BaseTest{

	@Autowired MyEELogic myEELogic;
	@Autowired UserRepository userRepository;
	   
	@DataProvider(name = "testUsers")
	public Object[][] getUsers() {
		return new Object[][] {
			{ userRepository.findById(6), "green"}
		};
	    }
	    
	    @Test(dataProvider = "testUsers")
	    public void UpdateGroupUsageControl(User user, String status) {
	    	myEELogic.updateGroupUsage( user, status);
	    }
}
