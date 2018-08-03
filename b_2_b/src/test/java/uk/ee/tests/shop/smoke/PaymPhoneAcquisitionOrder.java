package uk.ee.tests.shop.smoke;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.ee.framework.business_flow.ShopLogic;
import uk.ee.framework.business_objects.dao.billing_details.BillingDetails;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.business_objects.dao.order_management.constant.PLAN;
import uk.ee.framework.business_objects.dao.order_management.constant.SHOP_OPTIONS;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.elements.sections.shop.constants.CustomerType;
import uk.ee.framework.elements.sections.shop.constants.DeliveryOption;
import uk.ee.framework.elements.sections.shop.constants.PlanType;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;

@Test(groups = "Smoke")
public class PaymPhoneAcquisitionOrder extends BaseTest {
    @Autowired ShopMap shopMap;
    @Autowired ShopLogic shopLogic;
    private Order order;

    @BeforeMethod
    public void init(){
        order = new Order();
        order.setName("iphone-se-16gb-rose-gold")
                .setOptions(SHOP_OPTIONS.PHONE)
                .setBasketOrder(0)
                .setBuyFromSection(shopMap.PAYM_PHONES)
                .setPlan(PLAN.BEST_SELLING);
    }

    @DataProvider(name = "details")
    public Object[][] details(){
        return new Object[][]{
                {PlanType.PAYG},
                {DeliveryOption.HOME},
                {"AL109BW"},
                {CustomerType.EXISTING}
                //TODO continue
        };
    }

    @Test(dataProvider = "details")
    public void run(final String planType,
                    final String deliveryAddress,
                    final String postCode,
                    final String customerType,
                    final Customer customer,
                    final BillingDetails billingDetails,
                    final PaymentDetails paymentDetails){
        shopLogic.phoneOrder(order,planType, deliveryAddress, postCode, customerType, customer, billingDetails, paymentDetails);
        //TODO continue


    }
}
