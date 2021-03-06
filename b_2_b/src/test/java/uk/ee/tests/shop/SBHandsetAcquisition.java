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
 * Created by prabhu_s on 07/01/16.
 */
@Test(groups = {"Regression"})
public class SBHandsetAcquisition extends BaseTest {

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

    @DataProvider(name = "testUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"SB", "deliverToHome", "LS101LJ", "false",
                customerRepository.findById(2),
                billingDetailsRepository.findById(1),
				paymentDetailsRepository.findById(1)}};
    }

    @Test(dataProvider = "testUsers")
    public void SBPhoneAcquisition(final String planType,
            final String deliveryAddress,
            final String postCode,
            final String customerType,
            final Customer customerObj,
            final BillingDetails bdObj,
            final PaymentDetails pdObj) {

        Order order = new Order();
        ArrayList<String> extras = new ArrayList<>();
        extras.add("No Selection");
        extras.add("Add FULL COVER");
        order.setName("iphone-6s-16gb-gold").setCapacity("64GB").setOptions
				(SHOP_OPTIONS.PHONE)
                .setBuyFromSection(shopMap.SB_PHONES).setCalls(CALLS.NO_SELECTION).setPlan(PLAN.BEST_SELLING)
                .setExtras(extras);
        shopLogic.SBphoneOrder(order, planType, postCode, customerType,
                customerObj, bdObj, pdObj);
    }

}
