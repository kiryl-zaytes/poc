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
import uk.ee.framework.business_objects.dao.order_management.constant.ACCOUNT;
import uk.ee.framework.business_objects.dao.order_management.constant.CALLS;
import uk.ee.framework.business_objects.dao.order_management.constant
        .SHOP_OPTIONS;
import uk.ee.framework.business_objects.dao.order_management.constant.TERMS;
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
 * This class is a testing script for Validate SB Tablet Acqusition
 */
@Test(groups = {"Regression"})
public class SBTabletAcqusition extends BaseTest {

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
     * SoleTrader/LimitedPartner is used to select the right button in the pop
     * up.
     *
     * @return
     */
    @DataProvider(name = "testUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"SB", "deliverToHome", "LS116EE", "false",
                customerRepository.findById(2),
                billingDetailsRepository.findById(2),
				paymentDetailsRepository.findById(2), "SoleTrader"}};
    }

    @Test(dataProvider = "testUsers")
    public void paygSimOnlyAcquisition(final String planType,
            final String deliveryAddress,
            final String postCode,
            final String customerType,
            final Customer customerObj,
            final BillingDetails bdObj,
            final PaymentDetails pdObj,
            final String typeOfBusiness) {

        Order order = new Order();
        ArrayList<String> extras = new ArrayList<>();
        extras.add("No Selection");
        extras.add("Add");
        order.setName("ipad-pro-9-7-inch-32gb-rose-gold").setCapacity("2GB")
				.setOptions(SHOP_OPTIONS.SB).setBuyFromSection(shopMap.SIMS)
				.setAccount(ACCOUNT.SB)
                .setCalls(CALLS.PHONE).setTermOfUsage(TERMS.MONTH12).setExtras(extras);
        shopLogic.makeSBTabletOrder(order, planType, postCode,
                customerType, customerObj, bdObj, pdObj, typeOfBusiness);
    }
}
