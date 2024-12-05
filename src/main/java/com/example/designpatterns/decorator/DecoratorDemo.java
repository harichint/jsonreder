package com.example.designpatterns.decorator;

/**
 * Decorator pattern (Structural DP) will add new things to an object without changing how it looks or works.
 * A new class is made around the old class, uses its basic features and adds on top of it.
 * Open and close principal is met. Dont use this when the old object functionality is outdated.
 */
public class DecoratorDemo {
    public static void main(String [] args) {
        Car baseCar = new BaseCar();
        baseCar.assemble();
        Car sportsCar = new SportsCarDecorator(new BaseCar());
        sportsCar.assemble();
    }
}
