package com.example.designpatterns.decorator;

public class BaseCar implements Car{

    @Override
    public void assemble() {
        System.out.println("Basic car is assembled");
    }
}
