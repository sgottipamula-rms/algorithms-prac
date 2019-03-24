package com.san.maps;

import java.util.*;

public class WordCountByDescending {

    public HashMap<String,Integer> getWordCount(String strings) {

        HashMap<String,Integer> wordCountMap = new HashMap<>();

        for(String str : strings.split(" ")) {

            wordCountMap.putIfAbsent(str,0);
            Integer count = wordCountMap.get(str);
            wordCountMap.put(str,++count);
        }


        //sort the map
        List<Map.Entry<String,Integer>> listOfWords = new LinkedList<>();
        for(Map.Entry<String,Integer> entry : wordCountMap.entrySet())
            listOfWords.add(entry);
        listOfWords.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        wordCountMap = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> entry : listOfWords) {
            wordCountMap.put(entry.getKey(), entry.getValue());
        }

        return wordCountMap;
    }


    public static void main(String[] args) {
        WordCountByDescending wordCountByDescending = new WordCountByDescending();

        System.out.println(
        wordCountByDescending.getWordCount("san ban can tan man pan ban tan")
        );
    }


}
