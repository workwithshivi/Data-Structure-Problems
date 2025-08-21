package com.DS.slidingWindowProblems;

public class NextDoublicateSubArray {

    /*
    you have a given array of N elements,
    you have to find the largest sub-array length of next duplicate element.
    */
    public static void main(String[] args) {
        String s = "Hello how are you doing";
        //String s ="Enabling this will hide your contributions and activity from your GitHub profile and from social features like followers, stars, feeds, leaderboards and releases";
        s=s.toUpperCase();
        int first = 0;
        int last;
        int maxLength = 1;
        long startTime, endTime;
        startTime= System.currentTimeMillis();
        while (first<s.length()-1) {
            last = first+1;
            while (last < s.length()) {
                if (s.charAt(first) == s.charAt(last)) {
                    maxLength = Math.max(maxLength, last - first + 1);
                }
                last++;
            }
            first++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Result: "+maxLength+" Time Taken:"+(endTime-startTime));

        /*Solution 2*/
        maxLength = 1;
        first =0;
        startTime = System.currentTimeMillis();
        while (first!= s.length()){
            last=s.length()-1;
            while (last!=first){
                if (s.charAt(first) == s.charAt(last)) {
                    maxLength = Math.max(maxLength, last - first + 1);
                    break;
                }
                last--;
            }
            first++;
        }
        endTime= System.currentTimeMillis();
        System.out.println("Result: "+maxLength+" Time Taken:"+(endTime-startTime));
    }
}
