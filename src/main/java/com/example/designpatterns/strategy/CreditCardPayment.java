package com.example.designpatterns.strategy;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Amount payed: " + amount);
    }
}
