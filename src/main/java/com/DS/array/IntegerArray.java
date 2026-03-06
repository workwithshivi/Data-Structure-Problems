package com.DS.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IntegerArray {

    // ─────────────────────────────────────────────
    // 1. DECLARATION & INITIALIZATION
    // ─────────────────────────────────────────────
    static void declarationAndInitialization() {
        System.out.println("\n========== DECLARATION & INITIALIZATION ==========");

        // Method 1: Declare then assign
        int[] arr1 = new int[5];
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        arr1[3] = 40;
        arr1[4] = 50;
        System.out.println("Method 1 (declare then assign): " + Arrays.toString(arr1));

        // Method 2: Inline initialization
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Method 2 (inline):              " + Arrays.toString(arr2));

        // Method 3: Using new keyword with values
        int[] arr3 = new int[]{10, 20, 30, 40, 50};
        System.out.println("Method 3 (new with values):     " + Arrays.toString(arr3));

        // Method 4: Using Arrays.fill
        int[] arr4 = new int[5];
        Arrays.fill(arr4, 7);
        System.out.println("Method 4 (Arrays.fill):         " + Arrays.toString(arr4));

        // Method 5: Using Scanner
        Scanner sc = new Scanner(System.in);
        int[] arr5 = new int[3];
        System.out.print("Method 5 - Enter 3 integers: ");
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = sc.nextInt();
        }
        System.out.println("Method 5 (user input):          " + Arrays.toString(arr5));

        // Method 6: Using a loop (pattern fill)
        int[] arr6 = new int[5];
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = (i + 1) * 10;  // 10, 20, 30, 40, 50
        }
        System.out.println("Method 6 (loop fill):           " + Arrays.toString(arr6));
    }

    // ─────────────────────────────────────────────
    // 2. TRAVERSAL
    // ─────────────────────────────────────────────
    static void traversal(int[] arr) {
        System.out.println("\n========== TRAVERSAL ==========");

        // Method 1: for loop
        System.out.print("Method 1 (for loop):        ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Method 2: for-each
        System.out.print("\nMethod 2 (for-each):        ");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        // Method 3: while loop
        System.out.print("\nMethod 3 (while loop):      ");
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i++] + " ");
        }

        // Method 4: Arrays.toString
        System.out.println("\nMethod 4 (Arrays.toString): " + Arrays.toString(arr));

        // Method 5: Reverse traversal
        System.out.print("Method 5 (reverse):         ");
        for (int j = arr.length - 1; j >= 0; j--) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }

    // ─────────────────────────────────────────────
    // 3. SORTING
    // ─────────────────────────────────────────────
    static void sorting(int[] arr) {
        System.out.println("\n========== SORTING ==========");

        // Method 1: Arrays.sort ascending
        int[] copy1 = arr.clone();
        Arrays.sort(copy1);
        System.out.println("Method 1 (Arrays.sort ascending):   " + Arrays.toString(copy1));

        // Method 2: Bubble Sort: Repeatedly swap adjacent elements if they are in the wrong order, bubbling the largest to the end each pass.
        int[] bubble = arr.clone();
        for (int i = 0; i < bubble.length - 1; i++) {
            for (int j = 0; j < bubble.length - i - 1; j++) {
                if (bubble[j] > bubble[j + 1]) {
                    int temp = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = temp;
                }
            }
        }
        System.out.println("Method 2 (Bubble Sort):              " + Arrays.toString(bubble));

        // Method 3: Selection Sort: Find the minimum element from the unsorted part and place it at the beginning each pass.
        int[] selection = arr.clone();
        for (int i = 0; i < selection.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < selection.length; j++) {
                if (selection[j] < selection[minIdx]) minIdx = j;
            }
            int temp = selection[minIdx];
            selection[minIdx] = selection[i];
            selection[i] = temp;
        }
        System.out.println("Method 3 (Selection Sort):           " + Arrays.toString(selection));

        // Method 4: Insertion Sort: Pick each element and insert it into its correct position in the already sorted portion, shifting others right.
        int[] insertion = arr.clone();
        for (int i = 1; i < insertion.length; i++) {
            int key = insertion[i];
            int j = i - 1;
            while (j >= 0 && insertion[j] > key) {
                insertion[j + 1] = insertion[j];
                j--;
            }
            insertion[j + 1] = key;
        }
        System.out.println("Method 4 (Insertion Sort):           " + Arrays.toString(insertion));

        // Method 5: Descending order
        int[] desc = arr.clone();
        Arrays.sort(desc);
        int left = 0, right = desc.length - 1;
        while (left < right) {
            int temp = desc[left];
            desc[left++] = desc[right];
            desc[right--] = temp;
        }
        System.out.println("Method 5 (Descending):               " + Arrays.toString(desc));

        // method 6: stream api
        int[] strmArr = arr.clone();

         int [] sorted =Arrays.stream(strmArr).sorted().toArray();
        System.out.println("stream :" + Arrays.toString(sorted));

       int[]  rev =Arrays.stream(sorted).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println("stream reverse :" + Arrays.toString(rev));
    }

    // ─────────────────────────────────────────────
    // 4. DELETION
    // ─────────────────────────────────────────────
    static int[] deletion(int[] arr) {
        System.out.println("\n========== DELETION ==========");

        // Method 1: Delete by index
        int deleteIndex = 2;
        int[] afterIndex = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != deleteIndex) afterIndex[j++] = arr[i];
        }
        System.out.println("Method 1 (delete index " + deleteIndex + "):      " + Arrays.toString(afterIndex));

        // Method 2: Delete by value
        int deleteValue = 30;
        int[] afterValue = new int[arr.length - 1];
        int idx = 0;
        for (int n : arr) {
            if (n != deleteValue) afterValue[idx++] = n;
        }
        System.out.println("Method 2 (delete value " + deleteValue + "):     " + Arrays.toString(afterValue));

        // Method 3: Arrays.copyOf (remove last element)
        int[] trimmed = Arrays.copyOf(arr, arr.length - 1);
        System.out.println("Method 3 (Arrays.copyOf trim last):  " + Arrays.toString(trimmed));

        // Method 4: Arrays.copyOfRange (remove first element)
        int[] noFirst = Arrays.copyOfRange(arr, 1, arr.length);
        System.out.println("Method 4 (copyOfRange no first):     " + Arrays.toString(noFirst));

        return afterIndex;
    }

    // ─────────────────────────────────────────────
    // 5. SPECIFIC / UTILITY METHODS
    // ─────────────────────────────────────────────
    static void specificMethods(int[] arr) {
        System.out.println("\n========== SPECIFIC METHODS ==========");

        // Length
        System.out.println("Length:                        " + arr.length);

        // Sum & Average
        int sum = 0;
        for (int n : arr) sum += n;
        System.out.println("Sum:                           " + sum);
        System.out.println("Average:                       " + (double) sum / arr.length);

        // Min & Max (manual)
        int min = arr[0], max = arr[0];
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        System.out.println("Min:                           " + min);
        System.out.println("Max:                           " + max);

        // Linear Search
        int searchVal = 30;
        int foundAt = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchVal) {
                foundAt = i;
                break;
            }
        }
        System.out.println("Linear Search (" + searchVal + ") at index:  " + foundAt);

        // Binary Search (on sorted copy)
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int bsResult = Arrays.binarySearch(sorted, searchVal);
        System.out.println("Binary Search (" + searchVal + ") at index:  " + bsResult);

        // Copy
        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println("Copied array:                  " + Arrays.toString(copy));

        // Copy range
        int[] range = Arrays.copyOfRange(arr, 1, 4);
        System.out.println("copyOfRange(1,4):               " + Arrays.toString(range));

        // Compare two arrays
        int[] other = {10, 20, 30, 40, 50};
        System.out.println("Arrays.equals:                 " + Arrays.equals(arr, other));

        // 2D Array (bonus)
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("2D Array (deepToString):       " + Arrays.deepToString(matrix));

        // Fill a range
        int[] fillRange = arr.clone();
        Arrays.fill(fillRange, 1, 3, 99);  // fill index 1 to 3 with 99
        System.out.println("Arrays.fill(1,3,99):           " + Arrays.toString(fillRange));
    }

    // ─────────────────────────────────────────────
    // MAIN
    // ─────────────────────────────────────────────
    public static void main(String[] args) {
        declarationAndInitialization();

        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("\n>>> Working array: " + Arrays.toString(arr));

        traversal(arr);
        sorting(arr);
        deletion(arr);
        specificMethods(arr);
    }
}
