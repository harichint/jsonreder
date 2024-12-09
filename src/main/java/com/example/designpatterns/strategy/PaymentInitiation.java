package com.example.designpatterns.strategy;

/**
 * This is a context class, it can be in which context the payment initiated for example through a
 * shopping-cart or other wire transfer
 */
public class PaymentInitiation {
    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void initiatePayment(double amount) {
        this.paymentStrategy.pay(amount);
    }
}
