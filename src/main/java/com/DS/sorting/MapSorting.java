package com.DS.sorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSorting {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("k",3);
        map.put("a",1);
        map.put("s",5);
        map.put("b",7);
        map.put("t",4);
        System.out.println(map);

        Map<String, Integer> newMap = keySorting(map);
        System.out.println(newMap);
        Map<String, Integer> newMap2 = valueSorting(map);
        System.out.println(newMap2);

        String str = "Java Programming Language";
        Map<String,Integer> frequencyMap=findFrequencies(str);
        System.out.println(frequencyMap);

    }

    private static Map<String, Integer> findFrequencies(String str) {
        Set<String> set = Stream.of(str).collect(Collectors.toSet());
        List<char[]> tmp = List.of(str.toCharArray());

        Map<String, Integer> fq = new HashMap<>();
                set.forEach(a->
                        fq.put(a,Collections.frequency(tmp,a))

        );
                return fq;
    }

    static Map<String,Integer> valueSorting(Map<String,Integer> unorderdMap){

        LinkedHashMap<String, Integer> sortedMap = unorderdMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .skip(1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldKey,oldValue)-> oldValue,
                        LinkedHashMap::new
                ));
         return sortedMap;


    }

    static Map<String,Integer> keySorting(Map<String,Integer> unorderdMap){

        LinkedHashMap<String, Integer> sortedMap = unorderdMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldKey, OldValue) -> oldKey, LinkedHashMap::new
                ));

        return sortedMap;
    }
}
