package uk.ee.tests.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.ee.framework.business_flow.ShopLogic;
import uk.ee.framework.business_objects.dao.rsalogin.RSALoginDAO;
import uk.ee.framework.business_objects.dao.rsalogin.RSALoginDAORepository;
import uk.ee.framework.site_map.ShopMap;
import uk.ee.tests.base.BaseTest;

/**
 * Created by prabhu_s on 07/07/2016
 */

@Test(groups = {"Regression"})
public class RSAStockChecker extends BaseTest {

    @Autowired
    ShopLogic shopLogic;
    @Autowired
    ShopMap shopMap;

    @Autowired
    RSALoginDAORepository rsaLoginDAORepository;

    @DataProvider(name = "testUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"Handset", rsaLoginDAORepository
                .findByEmployeeId("123456"), "Yes"}};
    }

    /**
     * @param deviceType
     * @param rsaLogObj
     * @param confirmRetailStr
     */
    @Test(dataProvider = "testUsers")
    public void rsaStockCheckerValidation(final String deviceType,
            final RSALoginDAO rsaLogObj,
            final String confirmRetailStr) {

        shopLogic.rsaStockCheckervalidation(deviceType, rsaLogObj,
                confirmRetailStr);
//         rsaLoginDAORepository.save(createLogin());
    }
}
