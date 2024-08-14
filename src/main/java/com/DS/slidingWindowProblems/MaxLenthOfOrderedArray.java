package com.DS.slidingWindowProblems;


import java.util.stream.IntStream;

public class MaxLenthOfOrderedArray {
    /*
        you have a given array of N elements,
        you have to find the length sub-array such that elements are in increasing order
         */
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 10, 11, 17, 3, 2, 4, 5, 6, 7, 8};
        int first = 0, last = 1;
        int maxLength = 1;
        while (last < arr.length - 1) {
            if (arr[last] < arr[last + 1]) {
                maxLength = Math.max(maxLength, last - first + 1);
            } else {
                first = last;
            }
            last++;
        }
        System.out.println("Max length of sub-array: " + maxLength);
        System.out.println("Index: " + first + 1 + " " + last);
        IntStream.range(first, last).forEach(i -> System.out.print(arr[i + 1]));
    }
}
