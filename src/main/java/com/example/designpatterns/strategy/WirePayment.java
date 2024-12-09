package com.example.designpatterns.strategy;

public class WirePayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Payment made: " + amount);
    }
}
