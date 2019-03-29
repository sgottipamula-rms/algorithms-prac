package com.san.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfAString {

    public List<String> getPermutations(String str) {
        List<String> listOfResults = new ArrayList();

        if (str == null)
            return null;

        if (str.length() == 0) {
            listOfResults.add("");
            return listOfResults;
        }

        int count=0;
        while(count<str.length()) {
            char beg = str.charAt(0);
            String remainingString = str.substring(1);
            List<String> subStringPermutations = getPermutations(remainingString);
            for (String word : subStringPermutations) {
                listOfResults.add(beg + word);
            }

            str = remainingString + beg;//rotate string p(abc) + p(bca) + p(cab)
            count++;
        }

        return listOfResults;
    }


    public static void main(String[] args) {

        PermutationsOfAString permutationsOfAString = new PermutationsOfAString();

        System.out.println(permutationsOfAString.getPermutations("abca"));
    }
}
