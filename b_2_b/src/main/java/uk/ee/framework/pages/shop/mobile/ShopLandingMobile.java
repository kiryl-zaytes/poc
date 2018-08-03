package uk.ee.framework.pages.shop.mobile;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import uk.ee.framework.elements.sections.shop.BestSellingPlan;
import uk.ee.framework.elements.sections.shop.CustomizeDevice;
import uk.ee.framework.pages.shop.ShopLanding;

/**
 * Created by kiryl_zayets on 6/2/16.
 */

@Component
@Scope("prototype")
public class ShopLandingMobile extends ShopLanding {

    @FindBy(css = ".ee-product-panel .ee-prod-info-above-image")
    private CustomizeDevice customizeDevice;

    public CustomizeDevice getCustomizeDevice() {
        return customizeDevice;
    }

}
