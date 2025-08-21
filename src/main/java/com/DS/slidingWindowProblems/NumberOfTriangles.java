package com.DS.slidingWindowProblems;


import java.util.Arrays;

public class NumberOfTriangles {

    /*
    you have a given array of N elements,
    you have to find the number of possible triangles
    */
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 10, 11, 17};
        Arrays.sort(arr);
        // logic a+b>c, where a,b, and c are the side of a triangle
        int posibleTriangles = 0;
        int a = 0, b = 1, c = 2;
        if (arr.length < 3) {
            System.out.println(posibleTriangles);
            System.exit(0);
        } else {
            while (a < arr.length - 2) {
                while (b < arr.length - 1) {
                    while (c < arr.length) {
                        if (arr[a] + arr[b] > arr[c]) {
                            posibleTriangles++;
                            c++;
                        }
                        else {
                            c++;
                            break;
                        }
                    }
                    b++;
                }
                a++;
            }
            System.out.println(posibleTriangles);
        }


    }
}
