package com.example.designpatterns.builder;

/**
 * Builder design pattern (dp) is a Creational dp and handy to create huge Pojos.
 * 1) create the Pojo
 * 2) Create the Builder with same variables, but in setters return this.
 * 3) when creating the instance, we can use .setter.setter....
 * This way we dont need to add lengthy constructors or overloading constructors to handle the object instantiation.
 * This pattern will not work in case all constructor arguments are mandatory
 */
public class BuilderPatternDemo {
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
