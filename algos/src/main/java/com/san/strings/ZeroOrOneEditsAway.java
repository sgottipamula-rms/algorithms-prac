package com.san.strings;

public class ZeroOrOneEditsAway {

    public boolean isAway(String s1, String s2) {

        if(s1.equals(s2)) {
            return true;
        }

        //for replacement both strings have to be of same length
        if(s1.length()==s2.length()) {
            return doesReplacementWork(s1,s2);
        }

        if((getBiggerString(s1,s2).length() - getSmallerString(s1,s2).length()) ==1) {
            return doesAddingCharacterMakeEqual(getSmallerString(s1,s2),getBiggerString(s1,s2));
        }

        return false;
    }

    private String getBiggerString(String s1, String s2) {

        return s1.length()>s2.length()?s1:s2;
    }

    private String getSmallerString(String s1, String s2) {

        return s1.length()<s2.length()?s1:s2;
    }

    private boolean doesAddingCharacterMakeEqual(String small, String big) {

        char[] smallCharArr = small.toCharArray();
        char[] bigCharArr = big.toCharArray();

        boolean returnval = true;
        for(int i=0;i<bigCharArr.length;i++) {

            if(bigCharArr[i] != smallCharArr[i]) {
                returnval = (smallCharArr[i]==bigCharArr[i+1]);
                break;
            }

        }

        return returnval;
    }

    private boolean doesReplacementWork(String s1, String s2) {

        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();

        int numberOfDifferingChars = 0;
        for(int i=0;i<s1CharArr.length;i++) {

            if(s1CharArr[i]!=s2CharArr[i]) {
                numberOfDifferingChars++;
            }
        }

        return numberOfDifferingChars==1;
    }


    public static void main(String[] args) {
        ZeroOrOneEditsAway zeroOrOneEditsAway = new ZeroOrOneEditsAway();

        System.out.println(zeroOrOneEditsAway.isAway("pale","pale"));
        System.out.println(zeroOrOneEditsAway.isAway("pale","bale"));
        System.out.println(zeroOrOneEditsAway.isAway("pale","bala"));
        System.out.println(zeroOrOneEditsAway.isAway("pale","paale"));
    }
}
