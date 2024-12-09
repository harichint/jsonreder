package com.example.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Valid Anagram
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 * Example 1:
 * Input: s = "racecar", t = "carrace"
 * Output: true
 * Example 2:
 * Input: s = "jar", t = "jam"
 * Output: false
 * Constraints:
 * s and t consist of lowercase English letters.
 */
public class Anagram {
    public static void main(String [] args) {
        String s = "racecar";
        String t = "carrace";
        if (s == null || t == null || s.length() != t.length()) {
            System.out.println("invalid values");
            return;
        }
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        //sort the arrays to reduce time complexity
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
       //Here String.valueOf is used to convert the chararr to String
        if (String.valueOf(sCharArr).equalsIgnoreCase(String.valueOf(tCharArr)))
            System.out.println("They strings are Anagrams: " + s +", " + t);
        else  System.out.println("The given String are not Anagrams: "+ s +", " + t);

    }
}
