package com.example.designpatterns.observer;

public class Subscriber implements Observer{

    @Override
    public void update(int value) {
        System.out.println("Value changed: " + value) ;
    }
}
