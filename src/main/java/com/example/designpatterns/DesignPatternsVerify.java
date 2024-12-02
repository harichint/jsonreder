package com.example.designpatterns;

import com.example.pojo.Car;
import com.example.pojo.CarBuilder;

public class DesignPatternsVerify {
    public static void main(String [] args) {
        //Builder pattern
        CarBuilder builder = new CarBuilder() ;
            builder.id (2122)
               .brand ("Bugatti")
               .model("Chiron")
               .color("Blue");
        Car car = builder.build();
        System.out.println(car.toString());
    }
}
