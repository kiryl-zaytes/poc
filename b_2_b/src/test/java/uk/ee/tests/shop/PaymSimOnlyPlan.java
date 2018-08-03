package uk.ee.tests.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import uk.ee.framework.business_flow.ShopLogic;
import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.business_objects.dao.order_management.constant.ACCOUNT;
import uk.ee.framework.business_objects.dao.order_management.constant.CALLS;
import uk.ee.framework.business_objects.dao.order_management.constant
        .SHOP_OPTIONS;
import uk.ee.framework.business_objects.dao.order_management.constant.TERMS;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;

import java.util.ArrayList;

/**
 * Created by kiryl_zayets on 5/26/16.
 */
@Test(groups = {"Regression"})
public class PaymSimOnlyPlan extends BaseTest {
    @Autowired ShopLogic shopLogic;
    @Autowired ShopMap shopMap;

    @Test
    public void simToBasketCheckout() {
    	
        Order order = new Order();
        ArrayList<String> extras = new ArrayList<>();
        extras.add("No Selection");
        extras.add("Add");
        
        order.setCapacity("2GB").
                setOptions(SHOP_OPTIONS.SIM).
                setBuyFromSection(shopMap.SIMS).
                setAccount(ACCOUNT.PAYM).setCalls(CALLS.PHONE).
                setTermOfUsage(TERMS.MONTH12).setExtras(extras);
      //  shopLogic.makeOrder(order);
        
    }
}
