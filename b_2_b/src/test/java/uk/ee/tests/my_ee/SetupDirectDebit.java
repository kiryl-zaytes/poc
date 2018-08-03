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
 * Created by Prabhu S on 5/13/16.
 */
@Test(groups = {"Regression"})
public class SetupDirectDebit extends BaseTest {

    @Autowired MyEELogic myEELogic;
    @Autowired UserRepository userRepository;
    @Autowired DirectDebitRepository directDebitRepository;
    
    @DataProvider(name = "testUsers")
    public Object[][] getUsers() {
        return new Object[][] {
        		{ "Pay monthly", userRepository.findById(5), directDebitRepository
                    .findByTagsLike("%MARY%")}
        };
    }
    
    @Test(dataProvider = "testUsers")
    public void createDD(String type,User user, DirectDebit directDebit) {
        Assert.assertTrue(myEELogic.newDirectDebitRegistration(user, directDebit));
    }
}
