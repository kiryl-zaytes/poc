package uk.ee.tests.shop.smoke;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.ee.framework.pages.shop.ShopLanding;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;

import static org.testng.Assert.assertTrue;


@Test(groups = "Smoke")
public class MultipleGalleries extends BaseTest {
    @Autowired private ShopMap shopMap;
    @Autowired private ShopLanding shopLanding;

    @DataProvider(name = "galleries")
    public Object[][] galleries(){
        return new Object[][]{
                {shopMap.PAYG_MBB},
                {shopMap.PAYG_PHONES},
                {shopMap.PAYG_SIMS},
                {shopMap.PAYG_TABLETS},
                {shopMap.PAYG_CAMERAS},
                {shopMap.PAYM_MBB},
                {shopMap.PAYM_PHONES},
                {shopMap.PAYM_SIMS},
                {shopMap.PAYM_TABLETS},
                {shopMap.PAYM_CAMERAS}
        };
    }

    @Test(dataProvider = "galleries")
    public void run(String gallery){
        assertTrue(shopLanding.goToGalleryAndGetDevicesCount(gallery) > 0, "Gallery is empty!");
    }
}