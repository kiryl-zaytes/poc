package uk.ee.framework.elements.sections.shop.constants;

/**
 * Created by Aliaksandr_Lukashev1 on 7/8/2016.
 */
public enum CustomerType {
    EXISTING("true"),
    NOT_EXISTING("false");
    private String customer;

    CustomerType(String customer){
        this.customer = customer;
    }

    public String toString() {
        return customer;
    }
}
