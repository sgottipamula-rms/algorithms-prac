package com.san.strings;

import java.util.Arrays;

public class Anagrams {

    public boolean isAnagramWithSort(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();
        Arrays.sort(word1CharArray);
        Arrays.sort(word2CharArray);
        return Arrays.equals(word1CharArray, word2CharArray);
    }

    public boolean isAnagramWithoutSort(String word1, String word2) {

        if(word1.length()!=word2.length())
            return false;

        char[] word1CharArr = word1.toCharArray();
        char[] word2CharArr = word2.toCharArray();
        int[] word1CharFrequency = new int[256]; //Assuming all ascii
        int[] word2CharFrequency = new int[256];

        for(int i=0;i<word1.length();i++) {
            int char1AsciiValue = (int)word1CharArr[i];
            word1CharFrequency[char1AsciiValue] = word1CharFrequency[char1AsciiValue]+1;

            int char2AsciiValue = (int)word2CharArr[i];
            word2CharFrequency[char2AsciiValue] = word2CharFrequency[char2AsciiValue]+1;
        }

        return Arrays.equals(word1CharFrequency,word2CharFrequency);
    }


    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.isAnagramWithoutSort("dos","god"));
    }

}
