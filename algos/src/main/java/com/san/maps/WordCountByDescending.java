package com.san.maps;

import java.util.*;

public class WordCountByDescending {

    public Map<Integer,Set<String>> getWordCountByDescending(String strings) {

        Map<String,Integer> cache = new HashMap<>();
        Map<Integer,Set<String>> reverseCache = new TreeMap<>();

        for(String str : strings.split(" ")) {
            int count = cache.getOrDefault(str,0);
            cache.put(str,++count);
        }

        for(Map.Entry<String,Integer> entry : cache.entrySet()) {

            Set<String> set = reverseCache.getOrDefault(entry.getValue(), new HashSet<>());
            set.add(entry.getKey());
            reverseCache.put(entry.getValue(), set);
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
