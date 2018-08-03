package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import uk.ee.framework.elements.sections.shop.BestSellingPlan;
import uk.ee.framework.elements.sections.shop.CustomizeDevice;

/**
 * Created by kiryl_zayets on 5/19/16.
 */
public class DetailDevice {

//    @FindBy(css = "div.ee-plan-card-container")
    @FindBy(xpath ="//*[@id='main']/div[2]/section[1]/div/div[6]/div[2]")
    BestSellingPlan bestSellingPlan;

    @FindBy(css = "div.ee-product-info")
    CustomizeDevice customizeDevice;

    public void paymHandsetAcquisitionCustomizeAndGoCheckout(String capacity){
        customizeDevice.getRandlomColor();
        customizeDevice.selectCapacity(capacity);
        bestSellingPlan.choosePlan();
    }

    public void paymMBBAcquisitionChoosePlan() {
    	bestSellingPlan.choosePlan();
		
	}
    
    
}
