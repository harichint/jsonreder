package com.example.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Easy:
 * Contains Duplicate
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 * Example 1:
 * Input: nums = [1, 2, 3, 3]
 * Output: true
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: false
 */
public class Duplicates {

        public static void main(String [ ] args) {
            int[] nums = new int []{1, 2, 3, 3};
            int size = Arrays.stream(nums).distinct().boxed().collect(Collectors.toList()).size();
            if (size < nums.length)
                System.out.println("This has duplicates");
            else System.out.println("This doesn't have duplicates");

        }
}


