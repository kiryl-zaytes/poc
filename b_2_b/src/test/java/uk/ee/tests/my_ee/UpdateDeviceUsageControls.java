package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;
/**
 * Created by prabhu_s on 6/01/16.
 */
@Test(groups = {"Regression"})
public class UpdateDeviceUsageControls extends BaseTest{

		@Autowired MyEELogic myEELogic;
	    @Autowired UserRepository userRepository;

	    /*
	     * addOn ={Use Data, Buy Data, Roaming, Call abroad}
	     * status ={Allow, Block}
	     */
	    @DataProvider(name = "testUsers")
	    public Object[][] getUsers() {
	        return new Object[][] {
	                { userRepository.findById(7), "Block", "Use Data" },
	        };
	    }

	    @Test(dataProvider = "testUsers")
	    public void deviceUsage(User user, String status, String addOn){
	        myEELogic.updateDeviceControls(user, status, addOn);
	    }
}
