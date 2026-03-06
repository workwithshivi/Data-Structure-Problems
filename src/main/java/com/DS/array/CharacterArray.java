package com.DS.array;

import java.util.Arrays;
import java.util.Scanner;


public class CharacterArray {

    // ─────────────────────────────────────────────
    // 1. DECLARATION & INITIALIZATION
    // ─────────────────────────────────────────────
    static void declarationAndInitialization() {
        System.out.println("\n========== DECLARATION & INITIALIZATION ==========");

        // Method 1: Declare then assign
        char[] arr1 = new char[5];
        arr1[0] = 'H';
        arr1[1] = 'e';
        arr1[2] = 'l';
        arr1[3] = 'l';
        arr1[4] = 'o';
        System.out.println("Method 1 (declare then assign): " + new String(arr1));

        // Method 2: Inline initialization
        char[] arr2 = {'J', 'a', 'v', 'a'};
        System.out.println("Method 2 (inline):              " + new String(arr2));

        // Method 3: From a String
        char[] arr3 = "Hello Java".toCharArray();
        System.out.println("Method 3 (from String):         " + new String(arr3));

        // Method 4: Using Arrays.fill
        char[] arr4 = new char[5];
        Arrays.fill(arr4, 'A');
        System.out.println("Method 4 (Arrays.fill):         " + new String(arr4));

        // Method 5: From Scanner input
        Scanner sc = new Scanner(System.in);
        System.out.print("Method 5 - Enter a word: ");
        char[] arr5 = sc.next().toCharArray();
        System.out.println("Method 5 (user input):          " + new String(arr5));
    }

    // ─────────────────────────────────────────────
    // 2. TRAVERSAL
    // ─────────────────────────────────────────────
    static void traversal(char[] arr) {
        System.out.println("\n========== TRAVERSAL ==========");

        // Method 1: for loop with index
        System.out.print("Method 1 (for loop):      ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Method 2: enhanced for-each loop
        System.out.print("\nMethod 2 (for-each):      ");
        for (char c : arr) {
            System.out.print(c + " ");
        }

        // Method 3: while loop
        System.out.print("\nMethod 3 (while loop):    ");
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }

        // Method 4: Arrays.toString
        System.out.println("\nMethod 4 (Arrays.toString): " + Arrays.toString(arr));

        // Method 5: Convert to String and print
        System.out.println("Method 5 (as String):       " + new String(arr));
    }

    // ─────────────────────────────────────────────
    // 3. SORTING
    // ─────────────────────────────────────────────
    static void sorting(char[] arr) {
        System.out.println("\n========== SORTING ==========");

        char[] copy = arr.clone(); // preserve original

        // Method 1: Arrays.sort (built-in ascending)
        Arrays.sort(copy);
        System.out.println("Method 1 (Arrays.sort ascending):  " + new String(copy));

        // Method 2: Manual Bubble Sort
        char[] bubble = arr.clone();
        for (int i = 0; i < bubble.length - 1; i++) {
            for (int j = 0; j < bubble.length - i - 1; j++) {
                if (bubble[j] > bubble[j + 1]) {
                    char temp = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = temp;
                }
            }
        }
        System.out.println("Method 2 (Bubble Sort):             " + new String(bubble));

        // Method 3: Descending order (reverse after sort)
        char[] desc = arr.clone();
        Arrays.sort(desc);
        // reverse manually
        int left = 0, right = desc.length - 1;
        while (left < right) {
            char temp = desc[left];
            desc[left++] = desc[right];
            desc[right--] = temp;
        }
        System.out.println("Method 3 (Descending):              " + new String(desc));
    }

    // ─────────────────────────────────────────────
    // 4. DELETION
    // ─────────────────────────────────────────────
    static char[] deletion(char[] arr) {
        System.out.println("\n========== DELETION ==========");

        // Method 1: Delete by index (shift left)
        int deleteIndex = 2;
        char[] afterIndexDelete = new char[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != deleteIndex) afterIndexDelete[j++] = arr[i];
        }
        System.out.println("Method 1 (delete index " + deleteIndex + "):    " + new String(afterIndexDelete));

        // Method 2: Delete by value
        char deleteChar = 'a';
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != deleteChar) sb.append(c);
        }
        System.out.println("Method 2 (delete char '" + deleteChar + "'):   " + sb.toString());

        // Method 3: Delete using Arrays.copyOf (trim last element)
        char[] trimmed = Arrays.copyOf(arr, arr.length - 1);
        System.out.println("Method 3 (Arrays.copyOf trim last): " + new String(trimmed));

        // Method 4: Delete first occurrence using String replace
        String result = new String(arr).replaceFirst("a", "");
        System.out.println("Method 4 (replaceFirst 'a'):        " + result);

        return afterIndexDelete;
    }

    // ─────────────────────────────────────────────
    // 5. SPECIFIC / UTILITY METHODS
    // ─────────────────────────────────────────────
    static void specificMethods(char[] arr) {
        System.out.println("\n========== SPECIFIC METHODS ==========");

        String str = new String(arr);

        // Search: linear search
        char search = 'v';
        int foundAt = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                foundAt = i;
                break;
            }
        }
        System.out.println("Search '" + search + "' found at index: " + foundAt);

        // Length
        System.out.println("Length:                  " + arr.length);

        // Convert to String
        System.out.println("To String:               " + str);

        // Reverse
        char[] reversed = new StringBuilder(str).reverse().toString().toCharArray();
        System.out.println("Reversed:                " + new String(reversed));

        // Uppercase / Lowercase
        System.out.println("Uppercase:               " + str.toUpperCase());
        System.out.println("Lowercase:               " + str.toLowerCase());

        // Check if letter/digit
        System.out.println("Is arr[0] a letter?      " + Character.isLetter(arr[0]));
        System.out.println("Is arr[0] a digit?       " + Character.isDigit(arr[0]));
        System.out.println("Is arr[0] uppercase?     " + Character.isUpperCase(arr[0]));

        // Compare two char arrays
        char[] other = {'J', 'a', 'v', 'a'};
        System.out.println("Arrays equal?            " + Arrays.equals(arr, other));

        // Frequency count of a character
        char countChar = 'a';
        long freq = str.chars().filter(c -> c == countChar).count();
        System.out.println("Frequency of '" + countChar + "':       " + freq);

        // Copy a range
        char[] rangeCopy = Arrays.copyOfRange(arr, 1, 3);
        System.out.println("copyOfRange(1,3):        " + new String(rangeCopy));

        // Binary Search (array must be sorted first)
        char[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        int bsResult = Arrays.binarySearch(sortedArr, 'v');
        System.out.println("BinarySearch 'v' in sorted: index " + bsResult);
    }

    // ─────────────────────────────────────────────
    // MAIN
    // ─────────────────────────────────────────────
    public static void main(String[] args) {
        declarationAndInitialization();

        char[] arr = {'J', 'a', 'v', 'a', 'C', 'o', 'd', 'e'};
        System.out.println("\n>>> Working array: " + new String(arr));

        traversal(arr);
        sorting(arr);
        deletion(arr);
        specificMethods(arr);
    }
}