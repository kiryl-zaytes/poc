package uk.ee.tests.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import uk.ee.framework.business_flow.ShopLogic;
import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.business_objects.dao.order_management.constant.CALLS;
import uk.ee.framework.business_objects.dao.order_management.constant.INSURANCE;
import uk.ee.framework.business_objects.dao.order_management.constant.PLAN;
import uk.ee.framework.business_objects.dao.order_management.constant
        .SHOP_OPTIONS;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;

import java.util.ArrayList;

/**
 * Created by kiryl_zayets on 5/23/16.
 */

@Test(groups = {"Regression"})
public class PaymPhoneBestPlan extends BaseTest {

    @Autowired ShopLogic shopLogic;
    @Autowired ShopMap shopMap;

    @Test
    public void phoneToBasketBestPlanSubscribing() {
        Order order = new Order();
        ArrayList<String> extras = new ArrayList<>();
        extras.add("No Selection");
        extras.add("Add FULL COVER");

        order.setName("iphone-6s").
                setCapacity("64GB").
                setOptions(SHOP_OPTIONS.PHONE).
                setBuyFromSection(shopMap.PAYM_PHONES).
                setCalls(CALLS.NO_SELECTION).
                setPlan(PLAN.BEST_SELLING).
                setExtras(extras);
       // shopLogic.makeOrder(order);
    }
}
