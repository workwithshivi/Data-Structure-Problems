package com.DS.array;


import java.util.*;
import java.util.stream.Collectors;

public class ArrayListDemo {

    // ─────────────────────────────────────────────
    // 1. DECLARATION & INITIALIZATION
    // ─────────────────────────────────────────────
    static void declarationAndInitialization() {
        System.out.println("\n========== DECLARATION & INITIALIZATION ==========");

        // Method 1: Empty ArrayList
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        System.out.println("Method 1 (empty then add):       " + list1);

        // Method 2: With initial capacity (performance optimization)
        ArrayList<Integer> list2 = new ArrayList<>(10); // capacity 10, size still 0
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println("Method 2 (initial capacity):     " + list2);

        // Method 3: From another collection
        ArrayList<Integer> list3 = new ArrayList<>(list1);
        System.out.println("Method 3 (from collection):      " + list3);

        // Method 4: Using Arrays.asList
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Method 4 (Arrays.asList):        " + list4);

        // Method 5: Using List.of (Java 9+) — immutable, wrapped into ArrayList
        ArrayList<Integer> list5 = new ArrayList<>(List.of(5, 10, 15, 20));
        System.out.println("Method 5 (List.of wrapped):      " + list5);

        // Method 6: Using Collections.addAll
        ArrayList<Integer> list6 = new ArrayList<>();
        Collections.addAll(list6, 100, 200, 300);
        System.out.println("Method 6 (Collections.addAll):   " + list6);
    }

    // ─────────────────────────────────────────────
    // 2. TRAVERSAL
    // ─────────────────────────────────────────────
    static void traversal(ArrayList<Integer> list) {
        System.out.println("\n========== TRAVERSAL ==========");

        // Method 1: for loop with index
        System.out.print("Method 1 (for loop):         ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Method 2: for-each
        System.out.print("\nMethod 2 (for-each):         ");
        for (int n : list) {
            System.out.print(n + " ");
        }

        // Method 3: Iterator
        System.out.print("\nMethod 3 (Iterator):         ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // Method 4: ListIterator (bidirectional)
        System.out.print("\nMethod 4 (ListIterator fwd): ");
        var lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.print(lit.next() + " ");
        }

        System.out.print("\nMethod 4 (ListIterator bwd): ");
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }

        // Method 5: Java 8 forEach + lambda
        System.out.print("\nMethod 5 (forEach lambda):   ");
        list.forEach(n -> System.out.print(n + " "));

        // Method 6: Java 8 forEach method reference
        System.out.print("\nMethod 6 (method reference): ");
        list.forEach(System.out::println);

        // Method 7: Java 8 Stream
        System.out.print("\nMethod 7 (stream):           ");
        list.stream().forEach(n -> System.out.print(n + " "));

        // Method 8: Java 8 Stream with filter
        System.out.print("\nMethod 8 (stream + filter):  ");
        list.stream()
                .filter(n -> n > 20)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
    }

    // ─────────────────────────────────────────────
    // 3. SORTING
    // ─────────────────────────────────────────────
    static void sorting(ArrayList<Integer> list) {
        System.out.println("\n========== SORTING ==========");

        // Method 1: Collections.sort ascending
        ArrayList<Integer> copy1 = new ArrayList<>(list);
        Collections.sort(copy1);
        System.out.println("Method 1 (Collections.sort asc):    " + copy1);


        // Method 2: Collections.sort descending
        ArrayList<Integer> copy2 = new ArrayList<>(list);
        Collections.sort(copy2, Collections.reverseOrder());
        System.out.println("Method 2 (Collections.sort desc):   " + copy2);

        // Method 3: list.sort with lambda ascending
        ArrayList<Integer> copy3 = new ArrayList<>(list);
        copy3.sort((a, b) -> a - b);
        System.out.println("Method 3 (list.sort lambda asc):    " + copy3);

        // Method 4: list.sort with lambda descending
        ArrayList<Integer> copy4 = new ArrayList<>(list);
        copy4.sort((a, b) -> b - a);
        System.out.println("Method 4 (list.sort lambda desc):   " + copy4);

        // Method 5: Comparator.naturalOrder
        ArrayList<Integer> copy5 = new ArrayList<>(list);
        copy5.sort(Comparator.naturalOrder());
        System.out.println("Method 5 (Comparator.naturalOrder): " + copy5);

        // Method 6: Comparator.reverseOrder
        ArrayList<Integer> copy6 = new ArrayList<>(list);
        copy6.sort(Comparator.reverseOrder());
        System.out.println("Method 6 (Comparator.reverseOrder): " + copy6);

        // Method 7: Java 8 Stream sorted
        List<Integer> copy7 = list.stream()
                .sorted()
                .toList();
        System.out.println("Method 7 (stream sorted asc):       " + copy7);

        // Method 8: Java 8 Stream sorted descending
        List<Integer> copy8 = list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Method 8 (stream sorted desc):      " + copy8);
    }

    // ─────────────────────────────────────────────
    // 4. DELETION
    // ─────────────────────────────────────────────
    static void deletion(ArrayList<Integer> list) {
        System.out.println("\n========== DELETION ==========");

        // Method 1: remove by index
        ArrayList<Integer> copy1 = new ArrayList<>(list);
        copy1.remove(2);  // removes element at index 2
        System.out.println("Method 1 (remove by index 2):        " + copy1);

        // Method 2: remove by value
        ArrayList<Integer> copy2 = new ArrayList<>(list);
        copy2.remove(Integer.valueOf(30));  // removes first occurrence of 30
        System.out.println("Method 2 (remove by value 30):       " + copy2);

        // Method 3: removeAll — remove a collection of values
        ArrayList<Integer> copy3 = new ArrayList<>(list);
        copy3.removeAll(Arrays.asList(10, 30, 50));
        System.out.println("Method 3 (removeAll [10,30,50]):     " + copy3);

        // Method 4: removeIf — Java 8 lambda
        ArrayList<Integer> copy4 = new ArrayList<>(list);
        copy4.removeIf(n -> n > 30);  // removes all elements > 30
        System.out.println("Method 4 (removeIf n > 30):          " + copy4);

        // Method 5: clear — remove all elements
        ArrayList<Integer> copy5 = new ArrayList<>(list);
        copy5.clear();
        System.out.println("Method 5 (clear):                    " + copy5);

        // Method 6: Iterator remove (safe removal during traversal)
        ArrayList<Integer> copy6 = new ArrayList<>(list);
        Iterator<Integer> it = copy6.iterator();
        while (it.hasNext()) {
            if (it.next() % 20 == 0) it.remove(); // removes multiples of 20
        }
        System.out.println("Method 6 (iterator remove % 20):     " + copy6);
    }

    // ─────────────────────────────────────────────
    // 5. SPECIFIC / UTILITY METHODS
    // ─────────────────────────────────────────────
    static void specificMethods(ArrayList<Integer> list) {
        System.out.println("\n========== SPECIFIC METHODS ==========");

        // size
        System.out.println("size():                        " + list.size());

        // get
        System.out.println("get(1):                        " + list.get(1));

        // set (update)
        ArrayList<Integer> copy = new ArrayList<>(list);
        copy.set(0, 999);
        System.out.println("set(0, 999):                   " + copy);

        // contains
        System.out.println("contains(30):                  " + list.contains(30));

        // indexOf / lastIndexOf
        ArrayList<Integer> withDupe = new ArrayList<>(Arrays.asList(10, 20, 30, 20, 10));
        System.out.println("indexOf(20):                   " + withDupe.indexOf(20));
        System.out.println("lastIndexOf(20):               " + withDupe.lastIndexOf(20));

        // isEmpty
        System.out.println("isEmpty():                     " + list.isEmpty());

        // subList
        System.out.println("subList(1,4):                  " + list.subList(1, 4));

        // toArray
        Object[] arr = list.toArray();
        System.out.println("toArray():                     " + Arrays.toString(arr));

        // addAll
        ArrayList<Integer> merged = new ArrayList<>(list);
        merged.addAll(Arrays.asList(60, 70, 80));
        System.out.println("addAll([60,70,80]):             " + merged);

        // retainAll (intersection)
        ArrayList<Integer> retain = new ArrayList<>(list);
        retain.retainAll(Arrays.asList(10, 30, 50));
        System.out.println("retainAll([10,30,50]):          " + retain);

        // Collections.min / max
        System.out.println("Collections.min:               " + Collections.min(list));
        System.out.println("Collections.max:               " + Collections.max(list));

        // Collections.frequency
        System.out.println("frequency(20) in withDupe:     " + Collections.frequency(withDupe, 20));

        // Collections.reverse
        ArrayList<Integer> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        System.out.println("Collections.reverse:           " + reversed);

        // Collections.shuffle
        ArrayList<Integer> shuffled = new ArrayList<>(list);
        Collections.shuffle(shuffled);
        System.out.println("Collections.shuffle:           " + shuffled);

        // Java 8 Stream — sum, min, max, average
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Stream sum:                    " + sum);

        double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Stream average:                " + avg);

        // Java 8 collect to new list (filter)
        List<Integer> filtered = list.stream()
                .filter(n -> n > 20)
                .toList();
        System.out.println("Stream filter (n > 20):        " + filtered);
    }

    // ─────────────────────────────────────────────
    // MAIN
    // ─────────────────────────────────────────────
    public static void main(String[] args) {
        declarationAndInitialization();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("\n>>> Working list: " + list);

        traversal(list);
        sorting(list);
        deletion(list);
        specificMethods(list);
    }
}
