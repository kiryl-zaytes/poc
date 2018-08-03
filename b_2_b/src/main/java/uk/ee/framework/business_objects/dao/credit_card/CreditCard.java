package uk.ee.framework.business_objects.dao.credit_card;

import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by kiryl_zayets on 5/2/16.
 */

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TAGS")
    private String tags;

    @Column(name = "CTN")
    private String ctn;
    @Column(name = "TOP_UP")
    private String topUp;
    @Column(name = "CARD_NUMBER")
    private String cardNumber;
    @Column(name = "POST_CODE")
    private String postCode;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "CARD_TYPE")
    private String cardType;
    @Column(name = "EXPIRY_MONTH")
    private String expiryMonth;
    @Column(name = "EXPIRY_YEAR")
    private String expiryYear;
    @Column(name = "SECURITY_CODE")
    private String securityCode;
    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;
    @Column(name = "ADDRESS_LINE2")
    private String adressLine2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Column(name = "SORT_CODE1")
    private String sortCode1;
    @Column(name = "SORT_CODE2")
    private String sortCode2;
    @Column(name = "SORT_CODE3")
    private String sortCode3;
    @Column(name = "DOB_DATE")
    private String dobDate;
    @Column(name = "DOB_MONTH")
    private String dobMonth;
    @Column(name = "DOB_YEAR")
    private String dobYear;
    @Column(name = "EMAIL")
    private String eMail;

    public CreditCard(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCtn() {
        return ctn;
    }

    public void setCtn(String ctn) {
        this.ctn = ctn;
    }

    public String getTopUp() {
        return topUp;
    }

    public void setTopUp(String topUp) {
        this.topUp = topUp;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAdressLine2() {
        return adressLine2;
    }

    public void setAdressLine2(String adressLine2) {
        this.adressLine2 = adressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSortCode1() {
        return sortCode1;
    }

    public void setSortCode1(String sortCode1) {
        this.sortCode1 = sortCode1;
    }

    public String getSortCode2() {
        return sortCode2;
    }

    public void setSortCode2(String sortCode2) {
        this.sortCode2 = sortCode2;
    }

    public String getSortCode3() {
        return sortCode3;
    }

    public void setSortCode3(String sortCode3) {
        this.sortCode3 = sortCode3;
    }

    public String getDobDate() {
        return dobDate;
    }

    public void setDobDate(String dobDate) {
        this.dobDate = dobDate;
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(String dobMonth) {
        this.dobMonth = dobMonth;
    }

    public String getDobYear() {
        return dobYear;
    }

    public void setDobYear(String dobYear) {
        this.dobYear = dobYear;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equal(getCtn(), that.getCtn()) &&
                Objects.equal(getTopUp(), that.getTopUp()) &&
                Objects.equal(getCardNumber(), that.getCardNumber()) &&
                Objects.equal(getPostCode(), that.getPostCode()) &&
                Objects.equal(getTitle(), that.getTitle()) &&
                Objects.equal(getFirstName(), that.getFirstName()) &&
                Objects.equal(getLastName(), that.getLastName()) &&
                Objects.equal(getPassword(), that.getPassword()) &&
                Objects.equal(getCardType(), that.getCardType()) &&
                Objects.equal(getExpiryMonth(), that.getExpiryMonth()) &&
                Objects.equal(getExpiryYear(), that.getExpiryYear()) &&
                Objects.equal(getSecurityCode(), that.getSecurityCode()) &&
                Objects.equal(getAddressLine1(), that.getAddressLine1()) &&
                Objects.equal(getAdressLine2(), that.getAdressLine2()) &&
                Objects.equal(getCity(), that.getCity()) &&
                Objects.equal(getAccountNumber(), that.getAccountNumber()) &&
                Objects.equal(getAccountName(), that.getAccountName()) &&
                Objects.equal(getSortCode1(), that.getSortCode1()) &&
                Objects.equal(getSortCode2(), that.getSortCode2()) &&
                Objects.equal(getSortCode3(), that.getSortCode3()) &&
                Objects.equal(getDobDate(), that.getDobDate()) &&
                Objects.equal(getDobMonth(), that.getDobMonth()) &&
                Objects.equal(getDobYear(), that.getDobYear()) &&
                Objects.equal(geteMail(), that.geteMail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCtn(), getTopUp(), getCardNumber(),
                getPostCode(), getTitle(), getFirstName(), getLastName(),
                getPassword(), getCardType(), getExpiryMonth(), getExpiryYear
                        (), getSecurityCode(), getAddressLine1(),
                getAdressLine2(), getCity(), getAccountNumber(), getAccountName(), getSortCode1(), getSortCode2(), getSortCode3(), getDobDate(), getDobMonth(), getDobYear(), geteMail());
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ctn='" + ctn + '\'' +
                ", topUp='" + topUp + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", postCode='" + postCode + '\'' +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", cardType='" + cardType + '\'' +
                ", expiryMonth='" + expiryMonth + '\'' +
                ", expiryYear='" + expiryYear + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", adressLine2='" + adressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", sortCode1='" + sortCode1 + '\'' +
                ", sortCode2='" + sortCode2 + '\'' +
                ", sortCode3='" + sortCode3 + '\'' +
                ", dobDate='" + dobDate + '\'' +
                ", dobMonth='" + dobMonth + '\'' +
                ", dobYear='" + dobYear + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
