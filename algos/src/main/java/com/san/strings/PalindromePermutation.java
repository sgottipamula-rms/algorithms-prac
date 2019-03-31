package com.san.strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    public boolean isPalindromePermutation(String str) {

        char[] chars = str.toCharArray();
        HashMap<Character,Integer> frequencyMap = new HashMap<>();


        for(Character ch : chars) {
            int count = frequencyMap.getOrDefault(ch,0);
            frequencyMap.put(ch,++count);
        }


        int oddFrequencyCount = 0;

        for(Integer frequency : frequencyMap.values()) {
            if(frequency%2==1) {
                oddFrequencyCount++;
            }
        }


        return oddFrequencyCount<=1;
    }


    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();

        System.out.println(palindromePermutation.isPalindromePermutation("mmo"));
    }
}
