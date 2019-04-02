package com.san.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfAString {

    //P(B)=B
    //P(AB)=A+P(B) + P(rotateAB=BA)
    ///                 P(BA) = B+P(A)    ==== AB, BA
    //
    //P(ABC) = A+P(BC), B+P(AC), C+P(AB)
    public List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();

        if(str.length()==1) {
            permutations.add(str.charAt(0)+"");
            return permutations;
        }

        int charCount = 0;
        while(charCount<str.length()) {
            Character head = str.charAt(0);
            String remainingString = str.substring(1);
            List<String> subPermutations = getPermutations(remainingString);

            for (String subPermutation : subPermutations) {
                permutations.add(head + subPermutation);
            }

            str = remainingString + head;
            charCount++;
        }

        return permutations;

    }

    public static void main(String[] args) {

        PermutationsOfAString permutationsOfAString = new PermutationsOfAString();

        System.out.println(permutationsOfAString.getPermutations("abc"));
    }
}
