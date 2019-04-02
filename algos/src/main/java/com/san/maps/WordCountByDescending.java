package com.san.maps;

import java.util.*;

public class WordCountByDescending {

    public Map<Integer,Set<String>> getWordCountByDescending(String strings) {

        Map<String,Integer> cache = new HashMap<>();
        Map<Integer,Set<String>> reverseCache = new TreeMap<>();

        for(String str : strings.split(" ")) {
            int count = cache.getOrDefault(str,0);
            Set<String> stringSet = reverseCache.getOrDefault(count,new HashSet<>());
            stringSet.remove(str);

            count++;
            cache.put(str,count);
            stringSet = reverseCache.getOrDefault(count,new HashSet<>());
            stringSet.add(str);
            reverseCache.put(count,stringSet);
        }


        return reverseCache;
    }

    public static void main(String[] args) {
        WordCountByDescending wordCountByDescending = new WordCountByDescending();

        System.out.println(
        wordCountByDescending.getWordCountByDescending("san ban can tan man pan ban tan")
        );
    }


}
