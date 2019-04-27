package com.san.trees;

import java.util.List;

public class NumberPadSearch {

    public char[] getT9Chars(char number) {
        switch (number) {
            case '2':
                return new char[]{'a','b','c'};
            default:
                break;
        }

        return null;
    }


    public void addValidWords(List<String> validwords, Trie trie, String prefix, String remainingDigits) {

        if( ! trie.prefixSearch(prefix))
            return;

        if(remainingDigits.length()==0 && trie.wholeSearch(prefix)) {
            validwords.add(prefix);
        }

        char number = remainingDigits.charAt(0);
        remainingDigits = remainingDigits.substring(1);


        for(char ch : getT9Chars(number)) {
            addValidWords(validwords,trie,""+prefix+ch,remainingDigits);
        }

    }
}
