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
        char[] word1CharArray = word1.toCharArray();
        StringBuilder stringBuilderForWord2 = new StringBuilder(word2);

        for (char ch : word1CharArray) {
            int index = stringBuilderForWord2.indexOf(String.valueOf(ch));
            if (index != -1) {
                stringBuilderForWord2.deleteCharAt(index);
            }
        }

        return stringBuilderForWord2.length() == 0;
    }

}
