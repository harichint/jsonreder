package com.example.javagen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Anagram Lists comparision
 */
public class General {

    public static void main(String [] args) {
        System.out.println('A' + 'B'); //131
//        if (true) break; //compilation error
        int $_ = 5;
        List<String> a = new ArrayList<>();
        a.add("bat");
        a.add("car race");
        a.add("race");
        a.add("pile");

        List<String> b = new ArrayList<>();
        b.add("tab");
        b.add("race car");
        b.add("care");
        b.add("lap");

       a.stream().forEach(e -> Arrays.sort(e.chars().toArray()));
       b.stream().forEach(e -> Arrays.sort(e.chars().toArray()));
        for (int i = 0; i < a.size(); i++) {
             char[]a1 = a.get(i).toCharArray();
             char [] b1 = b.get(i).toCharArray();
             Arrays.sort(a1);
             Arrays.sort(b1);
            if (Arrays.equals(a1,b1))
                System.out.println("Anagram: " + a.get(i) + ", " +b.get(i)) ;
            else
                System.out.println("Not Anagram : "+a.get(i) + ", " +b.get(i)) ;
        }
    }
    public static void main(String  args) {
        
    }
}
