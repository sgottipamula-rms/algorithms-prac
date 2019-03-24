package com.san.strings;

public class StringReplacer {
    public String replaceSpaces(String str) {
        char[] charArrayOfString = str.toCharArray();
        int numberOfSpaces = 0;

        for (char ch : charArrayOfString) {
            if (ch == ' ')
                numberOfSpaces++;
        }

        char[] newCharArrayOfString = new char[charArrayOfString.length + (numberOfSpaces * 3)];
        int newCharArrayOfStringIndex = 0;

        for (char ch : charArrayOfString) {
            if (ch == ' ') {
                newCharArrayOfString[newCharArrayOfStringIndex++] = '%';
                newCharArrayOfString[newCharArrayOfStringIndex++] = '2';
                newCharArrayOfString[newCharArrayOfStringIndex++] = '0';
            } else {
                newCharArrayOfString[newCharArrayOfStringIndex++] = ch;
            }
        }

        return new String(newCharArrayOfString);
    }
}
