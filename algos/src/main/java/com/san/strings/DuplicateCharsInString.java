package com.san.strings;

import java.util.BitSet;

public class DuplicateCharsInString {

    public boolean containsDuplicates(String str) {
        BitSet bitSet = new BitSet(256);
        char[] charArrayOfString = str.toCharArray();

        for (char ch : charArrayOfString) {
            int index = (int) ch;
            if (!bitSet.get(index)) {
                bitSet.set(index);
            } else {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        DuplicateCharsInString duplicateCharsInString = new DuplicateCharsInString();
        System.out.println(duplicateCharsInString.containsDuplicates("abcdefghiajklm"));
    }
}
