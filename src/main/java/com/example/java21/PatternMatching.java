package com.example.java21;

public class PatternMatching {
    enum Color{RED, GREEN, ORANGE;}
    public static void main(String [] args) {
        Object o = "RED";
        switch(o) {
            case String s -> System.out.println("String");
            case Color c -> System.out.println("Color");
            default -> System.out.println("other");

        }
        System.out.println("");

    }
}
