package uk.ee.framework.business_objects.dao;

import uk.ee.framework.business_objects.dao.credit_card.CreditCard;

/**
 * Created by kiryl_zayets on 5/8/16.
 */
public class Payment {
    public enum PAYMENT_CHOICE {
        FULL,
        ANOTHER
    }

    public enum CREDITCARD_CHOICE {
        EXISTING,
        ADD_NEW,
        REMOVE_AND_ADD
    }

    String amount;
    PAYMENT_CHOICE payment_choice;
    CreditCard creditCard;
    CREDITCARD_CHOICE creditcard_choice;


    public Payment() {
        this.payment_choice = PAYMENT_CHOICE.FULL;
        creditCard = null;
    }

    public Payment(String amount) {
        this.amount = amount;
        this.payment_choice = PAYMENT_CHOICE.ANOTHER;
        creditCard = null;
    }

    public Payment(String amount, CreditCard creditCard, PAYMENT_CHOICE paymentChoice) {
        this.amount = amount;
        this.creditCard = creditCard;
        this.payment_choice = paymentChoice;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public PAYMENT_CHOICE getPayment_choice() {
        return payment_choice;
    }

    public void setPayment_choice(PAYMENT_CHOICE payment_choice) {
        this.payment_choice = payment_choice;
    }

    public CREDITCARD_CHOICE getCreditcard_choice() {
        return creditcard_choice;
    }

    public void setCreditcard_choice(CREDITCARD_CHOICE creditcard_choice) {
        this.creditcard_choice = creditcard_choice;
    }
}
