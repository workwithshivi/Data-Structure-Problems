package com.DS.slidingWindowProblems;

import static java.lang.Math.max;

public class LengthEqualToK {

    /*
        you have a given array of N elements,
        you have to find a sub-array such that element sum of the sun-array should be <= K
         */

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 10, 10};
        int k = 14;
        int l = 0, r = 0, sum = 0, maxLength = 0;
        while (r < arr.length) {
            sum = sum + arr[r];
            // if sum is greater than k, we have to shrink the window just by 1 for optimization
            if (sum > k) {
                sum = sum - arr[l];
                l++;
            }
            if (sum <= k) {
                maxLength = max(maxLength, r - l + 1);
            }
            r++;
        }
        System.out.println(maxLength);
    }
}
