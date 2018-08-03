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
import uk.ee.framework.post_processor.Loggable;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;

import java.util.ArrayList;

import static uk.ee.framework.utils.CommonConstants.*;

/**
 * Created by Syamphaneendra Kalluri on 07/12/2016
 * <p>
 * This class is a testing script for Validate a Paym Upgrade.
 */

@Test(groups = {TEST_GROUP_REGRESSION})
public class PaymUpgradeValidation extends BaseTest {

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

    /**
     * @return
     */
    @DataProvider(name = DATA_PROVIDER_TESTUSERS)
    public Object[][] getUsers() {
        return new Object[][]{{PAYM, DELIVET_TO_HOME, COMMON_POSTCODE, FALSE,
                customerRepository.findById(2),
                billingDetailsRepository.findById(ONE),
				paymentDetailsRepository.findById(ONE)}};
    }

    /**
     * @param planType
     * @param deliveryAddress
     * @param postCode
     * @param customerType
     * @param customerObj
     * @param bdObj
     * @param pdObj
     */
    @Test(dataProvider = DATA_PROVIDER_TESTUSERS)
    public void paymPhoneUpgradation(final String planType,
            final String deliveryAddress,
            final String postCode,
            final String customerType,
            final Customer customerObj,
            final BillingDetails bdObj,
            final PaymentDetails pdObj) {

        Order order = new Order();
        ArrayList<String> extras = new ArrayList<>();
        extras.add(NO_SELECTION);
        extras.add(ADD_FULL_COVER);
        order.setName(IPHONE_6S_16GB_SPACE_GREY).setCapacity(CAPACITY_64GB)
				.setOptions(SHOP_OPTIONS.PHONEUPGRADE)
                .setBuyFromSection(shopMap.PAYM_PHONES).setCalls(CALLS
				.NO_SELECTION).setPlan(PLAN.BEST_SELLING)
                .setExtras(extras);
        shopLogic.phoneUpgradation(order, planType, deliveryAddress,
                postCode, customerType, customerObj, bdObj,
                pdObj);
        logger.debug("Exited from PaymPhoneAcquisition.paymPhoneUpgradation");
    }
}
