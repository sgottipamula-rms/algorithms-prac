package com.san.sorting;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;

public class Anagrams {

    public String[] sort(String[] strings) {

         Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getAsciiSumValue(o1) - getAsciiSumValue(o2);
            }
        });

        return strings;
    }

    public int getAsciiSumValue(String str) {

        int total = 0;

        for(byte b : str.getBytes(StandardCharsets.US_ASCII)) {
            total+= b;
        }

        return total;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Anagrams().sort(
                new String[]{"abc","def" ,"ghi", "bac", "jkl", "cba"})));
    }
}
