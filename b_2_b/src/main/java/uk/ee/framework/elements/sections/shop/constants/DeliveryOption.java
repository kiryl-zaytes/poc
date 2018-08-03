package uk.ee.framework.elements.sections.shop.constants;

import java.util.Optional;

/**
 * Created by Aliaksandr_Lukashev1 on 7/8/2016.
 */
public enum DeliveryOption {
    HOME("deliveryToHome"),
    STORE("deliveryToStore");
    private String option;

    DeliveryOption(String option){
        this.option = option;
    }

    @Override
    public String toString() {
        return option;
    }
}
