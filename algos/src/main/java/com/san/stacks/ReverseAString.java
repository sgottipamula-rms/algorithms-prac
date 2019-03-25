package com.san.stacks;

import java.util.Stack;

public class ReverseAString {

    public void reverseString(String str) {

        Stack<Character> stck = new Stack<>();

        for (char ch : str.toCharArray()) {
            stck.push(ch);
        }

        while( ! stck.isEmpty()) {
            System.out.println(stck.pop());
        }
    }
}
