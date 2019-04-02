package com.san.maps;

import java.util.*;

public class WordCountByDescending {

    public Map<Integer,Set<String>> getWordCountByDescending(String strings) {

        Map<String,Integer> wordCountMap = new HashMap<>();
        Map<Integer,Set<String>> descendingCountMap = new TreeMap<>();

        for(String str : strings.split(" ")) {
            int count = wordCountMap.getOrDefault(str,0);
            Set<String> stringSet = descendingCountMap.getOrDefault(count,new HashSet<>());
            stringSet.remove(str);

            count++;
            wordCountMap.put(str,count);
            stringSet = descendingCountMap.getOrDefault(count,new HashSet<>());
            stringSet.add(str);
            descendingCountMap.put(count,stringSet);
        }


        return descendingCountMap;
    }

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
        wordCountByDescending.getWordCountByDescending("san ban can tan man pan ban tan")
        );
    }


}
