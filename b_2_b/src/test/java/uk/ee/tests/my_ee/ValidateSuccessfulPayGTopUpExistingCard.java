package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.Payment;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;

@Test(groups = {"Regression"})
public class ValidateSuccessfulPayGTopUpExistingCard extends BaseTest{

	 @Autowired MyEELogic myEELogic;
	    @Autowired UserRepository userRepository;

	    @DataProvider(name = "testUsers")
	    public Object[][] getUsers() {
	        return new Object[][] {
	                { "Pay as you go", userRepository.findById(8)},
	        };
	    }

	    @Test(dataProvider = "testUsers")
	    public void topUp(String type, User user){
//	        Payment payment = new Payment("10", user.getCreditCard(), Payment.PAYMENT_CHOICE.ANOTHER);
//	        payment.setCreditcard_choice(Payment.CREDITCARD_CHOICE.EXISTING);
	        myEELogic.existingUseryTopUpExistingCreditCard(user);
	    }
}
