package com.san.maps;

import java.util.Hashtable;

public class MinimumWindowSubstring {

    public String getMinSubString(String string, String target) {

        //construct frequency table
        Hashtable<Character,Integer> frequencyTable = new Hashtable<>();
        for(Character ch : target.toCharArray()) {
            frequencyTable.putIfAbsent(ch,0);
            Integer frequency = frequencyTable.get(ch);
            frequencyTable.put(ch,++frequency);
        }

        //TODO

        return null;
    }
}
