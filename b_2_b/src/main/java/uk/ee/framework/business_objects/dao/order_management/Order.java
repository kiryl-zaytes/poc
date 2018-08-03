package uk.ee.framework.business_objects.dao.order_management;

import com.google.common.base.Objects;
import uk.ee.framework.business_objects.dao.order_management.constant.*;

import java.util.List;

/**
 * Created by kiryl_zayets on 5/23/16.
 */
public class Order {

    private String name;
    private String color;
    private String capacity;
    private String buyFromSection;
    private String voucher;
    private String sharedPlans;
    private int basketOrder = 0;
    private TERMS termOfUsage;
    private List<String> extras;
    private INSURANCE insurance;
    private CALLS calls;
    private SHOP_OPTIONS options;
    private PLAN plan;
    private ACCOUNT account;

    public String getName() {
        return name;
    }

    /**
     * @param name equals to item id (can be found in url or hmc)
     *            (e.g. "iphone-se-16gb-rose-gold" )
     * @return Order.class
     */
    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    /**
     * @param color is an attribute of a selected device
     *              can be found on product details page or
     *              from the id or from hmc (e.g. white, silver)
     * @return Order.class
     */
    public Order setColor(String color) {
        this.color = color;
        return this;
    }

    public String getCapacity() {
        return capacity;
    }

    /**
     * @param capacity is a size of a flash memory
     *                 (e.g. "64Gb", "128Gb")
     * @return
     */
    public Order setCapacity(String capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getBuyFromSection() {
        return buyFromSection;
    }

    public Order setBuyFromSection(String buyFromSection) {
        this.buyFromSection = buyFromSection;
        return this;
    }

    public INSURANCE getInsurance() {
        return insurance;
    }

    public Order setInsurance(INSURANCE insurance) {
        this.insurance = insurance;
        return this;
    }

    public String getVoucher() {
        return voucher;
    }

    public Order setVoucher(String voucher) {
        this.voucher = voucher;
        return this;
    }

    public CALLS getCalls() {
        return calls;
    }

    public Order setCalls(CALLS calls) {
        this.calls = calls;
        return this;
    }

    public String getSharedPlans() {
        return sharedPlans;
    }

    public Order setSharedPlans(String sharedPlans) {
        this.sharedPlans = sharedPlans;
        return this;
    }

    public SHOP_OPTIONS getOptions() {
        return options;
    }

    public Order setOptions(SHOP_OPTIONS options) {
        this.options = options;
        return this;
    }

    public PLAN getPlan() {
        return plan;
    }

    public Order setPlan(PLAN plan) {
        this.plan = plan;
        return this;
    }

    public List<String> getExtras() {
        return extras;
    }

    public Order setExtras(List<String> extras) {
        this.extras = extras;
        return this;
    }

    public ACCOUNT getAccount() {
        return account;
    }

    public Order setAccount(ACCOUNT account) {
        this.account = account;
        return this;
    }

    public TERMS getTermOfUsage() {
        return termOfUsage;
    }

    public Order setTermOfUsage(TERMS termOfUsage) {
        this.termOfUsage = termOfUsage;
        return this;
    }

    public int getBasketOrder() {
        return basketOrder;
    }

    public Order setBasketOrder(int basketOrder) {
        this.basketOrder = basketOrder;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equal(getBasketOrder(), order.getBasketOrder()) &&
                Objects.equal(getName(), order.getName()) &&
                Objects.equal(getColor(), order.getColor()) &&
                Objects.equal(getCapacity(), order.getCapacity()) &&
                Objects.equal(getBuyFromSection(), order.getBuyFromSection()) &&
                Objects.equal(getVoucher(), order.getVoucher()) &&
                Objects.equal(getSharedPlans(), order.getSharedPlans()) &&
                Objects.equal(getTermOfUsage(), order.getTermOfUsage()) &&
                Objects.equal(getExtras(), order.getExtras()) &&
                Objects.equal(getInsurance(), order.getInsurance()) &&
                Objects.equal(getCalls(), order.getCalls()) &&
                Objects.equal(getOptions(), order.getOptions()) &&
                Objects.equal(getPlan(), order.getPlan()) &&
                Objects.equal(getAccount(), order.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getColor(), getCapacity(),
                getBuyFromSection(), getVoucher(), getSharedPlans(),
                getBasketOrder(), getTermOfUsage(), getExtras(), getInsurance(), getCalls(), getOptions(), getPlan(), getAccount());
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", buyFromSection='" + buyFromSection + '\'' +
                ", voucher='" + voucher + '\'' +
                ", sharedPlans='" + sharedPlans + '\'' +
                ", basketOrder=" + basketOrder +
                ", termOfUsage=" + termOfUsage +
                ", extras=" + extras +
                ", insurance=" + insurance +
                ", calls=" + calls +
                ", options=" + options +
                ", plan=" + plan +
                ", account=" + account +
                '}';
    }
}
