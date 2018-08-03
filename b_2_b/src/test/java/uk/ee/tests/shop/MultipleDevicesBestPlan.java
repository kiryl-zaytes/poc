package uk.ee.tests.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.ee.framework.business_flow.ShopLogic;
import uk.ee.framework.business_flow.WebLogic;
import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.business_objects.dao.order_management.constant.PLAN;
import uk.ee.framework.business_objects.dao.order_management.constant
        .SHOP_OPTIONS;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kiryl_zayets on 5/30/16.
 */
@Test(groups = "Regression")
public class MultipleDevicesBestPlan extends BaseTest {

    @Autowired ShopLogic shopLogic;
    @Autowired WebLogic webLogic;
    @Autowired ShopMap shopMap;

    List<Order> orderList = new LinkedList<>();
    LinkedList<String> extrasForIphone = new LinkedList<>();
    LinkedList<String> extrasForIpad = new LinkedList<>();

    @BeforeMethod
    public void init() {
        // ToDo: remove conditions when bug for mobile is fixed
        if (!System.getProperty("type").equals("mobile")) {
            extrasForIphone.addAll(Arrays.asList(
                    "No Selection", "Add FULL COVER"));
            extrasForIpad.addAll(Arrays.asList(
                    "No Selection", "Add FULL COVER"));
        }

        orderList.add(new Order().setName("iphone-6s").
                setCapacity("64GB").
                setOptions(SHOP_OPTIONS.PHONE).
                setBasketOrder(0).
                setBuyFromSection(shopMap.PAYM_PHONES).
                setPlan(PLAN.BEST_SELLING).
                setExtras(extrasForIphone));

        orderList.add(new Order().setName("ipad-air-2").
                setCapacity("64GB").
                setOptions(SHOP_OPTIONS.TABLET).
                setBasketOrder(1).
                setBuyFromSection(shopMap.PAYM_TABLETS).
                setPlan(PLAN.BEST_SELLING).
                setExtras(extrasForIpad));
    }

    @Test
    public void phoneToBasketBestPlanSubscribing() {

        webLogic.webToShopNavigation();
//        shopLogic.makeOrder(orderList);

       // shopLogic.makeOrder(orderList);

    }
}
