package uk.ee.framework.business_objects.dao.user;

import uk.ee.framework.business_objects.dao.credit_card.CreditCard;

import javax.persistence.*;

/**
 * Created by kiryl_zayets on 4/28/16.
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TAGS")
    private String tags;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CREDIT_CARD", insertable=false, updatable=false)
    private CreditCard creditCard;


    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
