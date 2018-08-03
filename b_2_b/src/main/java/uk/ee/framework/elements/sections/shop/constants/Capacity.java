package uk.ee.framework.elements.sections.shop.constants;

/**
 * Created by Aliaksandr_Lukashev1 on 7/8/2016.
 */
public enum Capacity {
    C_64Gb("64Gb"),
    C_32Gb("32Gb"),
    C_128Gb("128Gb");
    private String option;

    Capacity(String option){
        this.option = option;
    }

    @Override
    public String toString() {
        return option;
    }
}
