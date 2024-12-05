package com.example.designpatterns.adapter;

public class JsonReader implements AdvanceFileReader {

    @Override
    public void readJson(String filename) {
        System.out.println("Reading Json File and converting into ");
    }

    @Override
    public void readXml(String fileName) {
    // no need to implement
    }
}
