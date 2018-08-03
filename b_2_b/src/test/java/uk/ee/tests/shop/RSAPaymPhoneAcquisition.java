package uk.ee.tests.shop;

import ch.qos.logback.classic.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.ee.framework.business_flow.ShopLogic;
import uk.ee.framework.business_objects.dao.billing_details.BillingDetails;
import uk.ee.framework.business_objects.dao.billing_details
        .BillingDetailsRepository;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.business_objects.dao.customer.CustomerRepository;
import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.business_objects.dao.order_management.constant.CALLS;
import uk.ee.framework.business_objects.dao.order_management.constant.PLAN;
import uk.ee.framework.business_objects.dao.order_management.constant
        .SHOP_OPTIONS;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.business_objects.dao.payment_details
        .PaymentDetailsRepository;
import uk.ee.framework.business_objects.dao.rsalogin.RSALoginDAO;
import uk.ee.framework.business_objects.dao.rsalogin.RSALoginDAORepository;
import uk.ee.framework.post_processor.Loggable;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;

import java.util.ArrayList;

import static uk.ee.framework.utils.CommonConstants.*;

/**
 * Created by Syamphaneendra Kalluri on 06/29/2016
 * <p>
 * This class is a testing script for Validate RSA PAYM consumer handset
 * acquisition.
 */

@Test(groups = {TEST_GROUP_REGRESSION})
public class RSAPaymPhoneAcquisition extends BaseTest {

    @Autowired
    ShopLogic shopLogic;
    @Autowired
    ShopMap shopMap;
    @Loggable
    protected Logger logger;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BillingDetailsRepository billingDetailsRepository;

    @Autowired
    PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    RSALoginDAORepository rsaLoginDAORepository;

    /**
     * @return
     */
    @DataProvider(name = DATA_PROVIDER_TESTUSERS)
    public Object[][] getUsers() {
        return new Object[][]{{PAYM, DELIVET_TO_HOME, COMMON_POSTCODE, FALSE,
                customerRepository.findById(2),
                billingDetailsRepository.findById(ONE),
				paymentDetailsRepository.findById(ONE),
                rsaLoginDAORepository.findByEmployeeId(STR_123456), YES,
				PAYM_PHONES}};
    }

    /**
     * @param planType
     * @param deliveryAddress
     * @param postCode
     * @param customerType
     * @param customerObj
     * @param bdObj
     * @param pdObj
     * @param rsaLogObj
     * @param confirmRetailStr
     * @param scenarioType
     */
    @Test(dataProvider = DATA_PROVIDER_TESTUSERS)
    public void paymPhoneAcquisition(final String planType,
            final String deliveryAddress,
            final String postCode,
            final String customerType,
            final Customer customerObj,
            final BillingDetails bdObj,
            final PaymentDetails pdObj,
            final RSALoginDAO rsaLogObj,
            final String confirmRetailStr,
            final String scenarioType) {
        logger.debug("Entered into RSAPaymPhoneAcquisition" +
				".paymPhoneAcquisition");
        Order order = new Order();
        ArrayList<String> extras = new ArrayList<>();
        extras.add(NO_SELECTION);
        extras.add(ADD_FULL_COVER);
        // samsung-galaxy-a3-midnight-black-payg for payg device name
        order.setName(IPHONE_6S_16GB_SPACE_GREY).setCapacity(CAPACITY_64GB)
				.setOptions(SHOP_OPTIONS.PHONE)
                .setBuyFromSection(shopMap.PAYM_PHONES).setCalls(CALLS
				.NO_SELECTION).setPlan(PLAN.BEST_SELLING)
                .setExtras(extras);
        shopLogic.rsaphoneOrder(order, planType, deliveryAddress, postCode,
				customerType, customerObj, bdObj, pdObj,
                rsaLogObj, confirmRetailStr, scenarioType);
        // rsaLoginDAORepository.save(createLogin());
        logger.debug("Exited from PaymPhoneAcquisition.paymPhoneAcquisition");
    }

    /**
     * For creating RSA Login table.
     *
     * @return RSALoginDAO
     */
    private RSALoginDAO createLogin() {
        RSALoginDAO rsaLoginDAO = new RSALoginDAO();
        rsaLoginDAO.setEmployeeId(STR_123456);
        rsaLoginDAO.setStoreId(STR_1234);
        rsaLoginDAO.setStoreCommCode(null);
        return rsaLoginDAO;
    }
}
