package com.example.designpatterns.strategy;

/**
 * Strategy design patterns is used to handle multiple processes in a certain way.
 * this is a behavioral design pattern. it has a root inteface which is implemented by
 * all different processes that belong to same category (i.e. transportation can be through
 * car/bike/hike/ship etc strategies
 * payment can be through wire, paypal, credit etc strategies) and three is a Context class which
 * should be able to handle any of the process. in our case the context is PaymentInitiation.
 * inside this Context, the strategy is set through the root inteface. then the Client when wants
 * to trigger a strategy, can pass the individual strategy based on the inputs they receive.
 * i.e. rest client based on its request can invoke specific strategy using a factory pattern.
 * Then they need to trigger the invocation of the strategy selected using Context.
 *
 * Strategy pattern is very handy as it perfectly applies Open/Clsoe principle. this is used when
 * we want to use different variants of algorithm within an object and switch form one to another
 * algorithm at runtime.
 * Use the pattern to isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.
 * Use the pattern when your class has a massive conditional statement that switches between different variants of the same algorithm.
 *
 * Dont use this when we absolutely know the strategies dont need to scale and
 *
 *
 */
public class StrategyDemo {
    public static void main(String [] args) {
        PaymentInitiation init = new PaymentInitiation();
        init.setPaymentStrategy(new CreditCardPayment());
        init.initiatePayment(20.2);
    }
}
