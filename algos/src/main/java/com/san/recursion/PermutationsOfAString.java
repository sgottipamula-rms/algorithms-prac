package com.san.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfAString {

    //P(B)=B
    //P(AB)=A+P(B) + P(rotateAB=BA)
    ///                 P(BA) = B+P(A)    ==== AB, BA (2 rotations for 2charstring)
    //
    //P(ABC) = A+P(BC), B+P(AC), C+P(AB) (3rotations for 3 char string)
    public List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();

        if(str.length()==1) {
            permutations.add(str);
            return permutations;
        }

        int rotations = str.length();
        while(rotations>0) {
            Character head = str.charAt(0);
            String remainingString = str.substring(1);
            List<String> subPermutations = getPermutations(remainingString);

            for (String subPermutation : subPermutations) {
                permutations.add(head + subPermutation);
            }

            str = remainingString + head;
            rotations--;
        }

        return permutations;

    }

    public static void main(String[] args) {

        PermutationsOfAString permutationsOfAString = new PermutationsOfAString();

        System.out.println(permutationsOfAString.getPermutations("abc"));
    }
}
