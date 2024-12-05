package com.example.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationPublisher implements Publisher {
    private List<Observer> observers = new ArrayList<>();
    int state = 0;

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerSubscriber(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for (var obs : observers) {
            obs.update(state);
        }
    }

}
