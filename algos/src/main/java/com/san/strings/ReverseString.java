package com.san.strings;

public class ReverseString {

    public String reverseString(String str) {
        char[] charArrOfString = str.toCharArray();
        int startIndex = 0;
        int endIndex = charArrOfString.length - 1;

        while (startIndex < endIndex) {
            char temp = charArrOfString[startIndex];
            charArrOfString[startIndex] = charArrOfString[endIndex];
            charArrOfString[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

        return new String(charArrOfString);
    }

    public String reverseStringUsingRecursion(String str) {
        if (str.length() == 1)
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }


    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();

        System.out.println(reverseString.reverseStringUsingRecursion("abc"));
    }
}
