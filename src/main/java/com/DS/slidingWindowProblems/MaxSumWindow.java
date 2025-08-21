package com.DS.slidingWindowProblems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumWindow {
    /*
        you have a given array of N elements and a integer k
        you have to find the largest sum by using consecutive K elements
        */
    public static void main(String[] args) {
        int[] arr = {2, -5, -1, 10, -2, 11, 17, -8, 7, 19, 17, 2};
        int k =4;
        int maxSum = 0;

        // calculating initial sum of first k elements
        maxSum=Arrays.stream(arr).limit(k).sum();
        int first =0, last = k-1;
        int tempSum;
        while (true){
            tempSum = maxSum;
            // removing previous element and adding next element
            tempSum = tempSum - Math.abs(arr[first]);
            first++;
            last++;
            if(last >= arr.length-1)
                break;
            tempSum = tempSum + arr[last];

            maxSum = Math.max(maxSum, tempSum);
        }
        System.out.println(maxSum);
    }
}
