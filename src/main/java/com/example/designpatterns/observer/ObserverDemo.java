package com.example.designpatterns.observer;

/**
 * Observer pattern is behavioral pattern. Publisher will
 * invoke the subscribers / obeservers method with a loop when there is a change to the
 * state of itself. the observers/subscribers can be managed with a request so that only intreseted
 * subscribers will be notified of the change.
 *
 */
public class ObserverDemo {
    public static void main(String [] args) {
        NotificationPublisher p  = new NotificationPublisher();
        Observer ob1 = new Subscriber();
        Observer ob2 = new Subscriber();
        p.registerSubscriber(ob1);
        p.registerSubscriber(ob2);
        p.setState(1);
        p.removeObserver(ob2);

    }
}


