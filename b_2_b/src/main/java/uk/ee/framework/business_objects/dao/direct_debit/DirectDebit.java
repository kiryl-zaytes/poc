package uk.ee.framework.business_objects.dao.direct_debit;

import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by Prabhu S on 5/10/16.
 */

@Entity
@Table(name = "Direct_Debit")
public class DirectDebit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Column(name = "TAGS")
    private String tags;

    public DirectDebit(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        DirectDebit that = (DirectDebit) o;
        return  Objects.equal(getAccountNumber(), that.getAccountNumber()) &&
                Objects.equal(getAccountName(), that.getAccountName()) &&
                Objects.equal(getSortCode1(), that.getSortCode1()) &&
                Objects.equal(getSortCode2(), that.getSortCode2()) &&
                Objects.equal(getSortCode3(), that.getSortCode3());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getAccountNumber(), getAccountName(), getSortCode1(), getSortCode2(), getSortCode3());
    }

    @Override
    public String toString() {
        return "DirectDebit{" +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", sortCode1='" + sortCode1 + '\'' +
                ", sortCode2='" + sortCode2 + '\'' +
                ", sortCode3='" + sortCode3 + '\'' +
                '}';
    }
}
