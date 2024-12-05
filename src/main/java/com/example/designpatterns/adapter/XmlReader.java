package com.example.designpatterns.adapter;

public class XmlReader implements AdvanceFileReader{

    @Override
    public void readJson(String filename) {
        //dont implement
    }

    @Override
    public void readXml(String fileName) {
        System.out.println("Reading Xml File");
    }
}
