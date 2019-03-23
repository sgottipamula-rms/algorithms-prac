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

        for (int i = 0; i < str.length(); i++) {
            char beg = str.charAt(0);
            String remainingString = str.substring(1);
            List<String> subStringPermutations = getPermutations(remainingString);
            for (String word : subStringPermutations) {
                listOfResults.add(beg + word);
            }

            str = remainingString + beg;//rotate string
        }

        return listOfResults;
    }


    public static void main(String[] args) {

        PermutationsOfAString permutationsOfAString = new PermutationsOfAString();

        System.out.println(permutationsOfAString.getPermutations("abc"));
    }
}
