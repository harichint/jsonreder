package com.example.pojo;

public class Car {
    private final int id;
    private final String brand;
    private final String model;
    private final String color;
    Car(int id, String brand, String model,
                    String color) {
         this.id = id;
         this.brand = brand;
         this.model = model;
         this.color = color;

    }
    public String toString() {
        if (this != null) {
            return this.id + ", " + this.brand + ", " + this.model + ", " + this.color;
        }
        return null;
    }
}