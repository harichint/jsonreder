package com.example.designpatterns.adapter;

import java.io.File;

/**
 * Adapter pattern is a structural design pattern. as the name suggests, it acts as an adapter
 * between two incompatible objects or even method names in those objects,
 * but need them to work together.
 * dont use this when the one of the objects can be easily converted into another. as this will introduce
 * complexity of have extra classes.
 * add two interfaces, one for adapter (so that more adapters can be created.
 * another for type of objects to be working together.
 * then concrete classes and an apdatper whcih will implement the interfaced created,
 */
public class AdapterDemo {

    public static void main(String [] args) {
        FileReadAdapter fileReadAdapter = new FileReadAdapter("Json");
        fileReadAdapter.readFile("Json", "Test.json");
    }
}
