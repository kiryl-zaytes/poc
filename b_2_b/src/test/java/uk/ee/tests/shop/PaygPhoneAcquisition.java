package uk.ee.tests.shop;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ch.qos.logback.classic.Logger;
import uk.ee.framework.business_flow.ShopLogic;
import uk.ee.framework.business_objects.dao.billing_details.BillingDetails;
import uk.ee.framework.business_objects.dao.billing_details.BillingDetailsRepository;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.business_objects.dao.customer.CustomerRepository;
import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.business_objects.dao.order_management.constant.CALLS;
import uk.ee.framework.business_objects.dao.order_management.constant.PLAN;
import uk.ee.framework.business_objects.dao.order_management.constant.SHOP_OPTIONS;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetailsRepository;
import uk.ee.framework.post_processor.Loggable;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;

/**
 * Created by Syamphaneendra Kalluri on 06/16/2016
 * 
 * This class is a testing script for Validate PAYG handset acquisition for new
 * customer.
 * 
 */
@Test(groups = { "Regression" })
public class PaygPhoneAcquisition extends BaseTest {

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
		return new Object[][] { { "PAYG", "deliverToHome", "LS116EE", "false", customerRepository.findById(1),
				billingDetailsRepository.findById(1), paymentDetailsRepository.findById(1) } };
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
	public void paygPhoneAcquisition(final String planType, final String deliveryAddress, final String postCode,
			final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		logger.debug("Entered into PaygPhoneAcquisition.paygPhoneAcquisition");
		Order order = new Order();
		ArrayList<String> extras = new ArrayList<>();
		extras.add("No Selection");
		extras.add("Add FULL COVER");
		//sony-xperia-m4-aqua-in-black-payg
		order.setName("samsung-galaxy-j3-2016-payg").setCapacity("64GB").setOptions(SHOP_OPTIONS.PHONE)
				.setBuyFromSection(shopMap.PAYG_PHONES).setCalls(CALLS.NO_SELECTION).setPlan(PLAN.BEST_SELLING)
				.setExtras(extras);
		shopLogic.phoneOrder(order, planType, deliveryAddress, postCode, customerType, customerObj, bdObj, pdObj);
		logger.debug("Exited from PaygPhoneAcquisition.paygPhoneAcquisition");
	}

}
