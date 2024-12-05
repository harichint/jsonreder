package com.example.designpatterns.observer;

public interface Publisher {
    void registerSubscriber(Observer ob);
    void removeObserver(Observer ob);
    void notifyObservers();
}
