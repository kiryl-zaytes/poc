package uk.ee.framework.elements.sections.shop.constants;

/**
 * Created by Aliaksandr_Lukashev1 on 7/8/2016.
 */
public enum PlanType {
    PAYM("paym"),
    PAYG("payg");
    private String option;

    PlanType(String option){
        this.option = option;
    }

    @Override
    public String toString() {
        return option;
    }
}
