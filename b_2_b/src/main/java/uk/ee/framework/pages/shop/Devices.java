package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import uk.ee.framework.elements.sections.shop.DeviceList;
import uk.ee.framework.elements.sections.shop.DeviceSearch;
import uk.ee.framework.elements.sections.shop.SelectDevice;
import uk.ee.framework.pages.BasePage;

/**
 * Created by kiryl_zayets on 5/19/16.
 */

@Component
@Scope("prototype")
public class Devices extends BasePage {

    DeviceList deviceList;
    DeviceSearch deviceSearch;
    
    @FindBy(css ="section#device-facet-search")		
    SelectDevice selectDevice;;

    public void selectDevice(String name){
        deviceList.selectDevice(name);
    }

    public void selectDeviceStockCheck(){		
    	    	selectDevice.selectDeviceToCompare();		
    }
}
