package com.example.designpatterns.adapter;

import java.io.File;

/**
 * Adapter pattern is a structural design pattern. as the name suggests, it acts as an adapter
 * between two incompatible objects but need them to work together.
 * dont use this when the one of the objects can be easily converted into another. as this will introduce
 * complexity of have extra classes.
 */
public class AdapterDemo {

    public static void main(String [] args) {
        FileReadAdapter fileReadAdapter = new FileReadAdapter("Json");
        fileReadAdapter.readFile("Json", "Test.json");
    }
}
