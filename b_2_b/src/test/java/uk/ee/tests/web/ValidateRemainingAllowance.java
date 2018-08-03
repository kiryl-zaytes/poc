package uk.ee.tests.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_flow.WebLogic;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;

/**
 * Created by prabhu_s on 5/27/16.
 */

@Test(groups = {"Regression"})
public class ValidateRemainingAllowance extends BaseTest{

	@Autowired MyEELogic myEELogic;
	@Autowired UserRepository userRepository;
	@Autowired WebLogic webLogic;
	
	@DataProvider(name = "testUsers")
    public Object[][] getUsers() {
        return new Object[][] {
                { userRepository.findByTagsLike("%PAYG%")},
        };
    }
	
	@Test(dataProvider ="testUsers")
	public void validateRemainingAllowance(User user){
		webLogic.webToMyeeNavigation();
//		String result = 
				myEELogic.validateRemainingAllowance(user);
//		System.out.println(result);
	}
}
