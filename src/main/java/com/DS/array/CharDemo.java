package com.DS.array;

public class CharDemo {

    public static void main(String[] args) {
        char[] arr = "Hello".toCharArray();
        System.out.println(arr);
        String str = new String(arr);
        String str2 = String.valueOf(arr);

        // here char array will be changed but STring will not be changed as with new keyword string has new reference
        arr[0] = 'Y';

        System.out.println("Char:" + arr);
        System.out.println( arr);
        System.out.println("String: "+ str);

        System.out.println(str2);


        //When a character works with mathematical operators, it behaves as an integer i.e. ASCII value
        char[] arr3 = {'1','2','3'};
        System.out.println(arr3[1]);
        System.out.println((int)arr3[1]);
        System.out.println(arr3[0]+arr3[1]);

        char c = 'A';
        int n = c;
        //it will print the ASCII value.
        System.out.println(n);
    }
}
