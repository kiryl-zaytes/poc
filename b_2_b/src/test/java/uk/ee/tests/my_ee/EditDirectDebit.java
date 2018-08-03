package uk.ee.tests.my_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uk.ee.framework.business_flow.MyEELogic;
import uk.ee.framework.business_objects.dao.direct_debit.DirectDebit;
import uk.ee.framework.business_objects.dao.direct_debit.DirectDebitRepository;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.business_objects.dao.user.UserRepository;
import uk.ee.tests.base.BaseTest;

/**
 * This class is used to edit and save the new direct debit details.
 * 
 * Created by Syamphaneendra kalluri on 08/05/16.
 */
@Test(groups = { "Regression" })
public class EditDirectDebit extends BaseTest {

	@Autowired
	MyEELogic myEELogic;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DirectDebitRepository directDebitRepository;

	@DataProvider(name = "testUsers")
	public Object[][] getUsers() {
		return new Object[][] { { "Pay monthly", userRepository.findById(1), directDebitRepository.findById(2) } };
	}

	@Test(dataProvider = "testUsers")
	public void createDD(final String type, final User user, final DirectDebit debit) {
		myEELogic.editDirectDebitRegistration(user, debit);
	}
}
