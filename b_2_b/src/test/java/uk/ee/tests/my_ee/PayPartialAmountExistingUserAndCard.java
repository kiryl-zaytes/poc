package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.Payment;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetailsRepository;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;

/**
 * 
 * This class is used pay partial amount for existing user.
 * 
 * Created by kiryl_zayets on 5/8/16.
 * 
 * Modified by Syamphaneendra kalluri on 08/04/16.
 */

@Test(groups = { "Regression" })
public class PayPartialAmountExistingUserAndCard extends BaseTest {

	@Autowired
	MyEELogic myEELogic;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;

    /*@DataProvider(name = "testUsers")
    public Object[][] getUsers() {
        return new Object[][] {
                { "Pay monthly", userRepository.findById(1) , "8673"},
                { "Pay as you go", userRepository.findById(4), "8673"},
        };
    }*/
    
	@DataProvider(name = "testUsers")
	public Object[][] getUsers() {
		return new Object[][] { { "Pay monthly", userRepository.findById(1), paymentDetailsRepository.findById(2), "8673" } };
	}

	@Test(dataProvider = "testUsers")
	public void pay(final String type, User user, final PaymentDetails pdObj, final String card) {
		Payment payment = new Payment("10", user.getCreditCard(), Payment.PAYMENT_CHOICE.ANOTHER);
		payment.setCreditcard_choice(Payment.CREDITCARD_CHOICE.EXISTING);
		myEELogic.existingUserPayBillWithExistingCreditCard(user, payment, pdObj, card);
	}

}
