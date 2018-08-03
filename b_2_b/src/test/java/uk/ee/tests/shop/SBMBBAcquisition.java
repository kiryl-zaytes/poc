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

/**
 * Created by Syamphaneendra Kalluri on 07/07/2016
 * <p>
 * This class is a testing script for Validate SB MBB Acquisition
 */
@Test(groups = {"Regression"})
public class SBMBBAcquisition extends BaseTest {
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
    @DataProvider(name = "testUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"SB", "deliverToHome", "LS101LJ", "false",
                customerRepository.findById(2),
                billingDetailsRepository.findById(1),
				paymentDetailsRepository.findById(1), "SoleTrader"}};
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
    @Test(dataProvider = "testUsers")
    public void mbbToBasketBestPlanSubscribing(final String planType,
            final String deliveryAddress,
            final String postCode,
            final String customerType,
            final Customer customerObj,
            final BillingDetails bdObj,
            final PaymentDetails pdObj,
            final String typeOfBusiness) {
        logger.info("Entered into mbbToBasketBestPlanSubscribing");
        Order order = new Order();
        ArrayList<String> extras = new ArrayList<>();
        extras.add("No Selection");
        extras.add("Add FULL COVER");
        order.setName("4gee-wifi").
                setOptions(SHOP_OPTIONS.SB).setBuyFromSection(shopMap.PAYM_MBB).setCalls(CALLS.NO_SELECTION)
                .setPlan(PLAN.BEST_SELLING).setExtras(extras);

        shopLogic.makeSBMBBOrder(order, planType, postCode, customerType,
                customerObj, bdObj, pdObj, typeOfBusiness);
    }
}
