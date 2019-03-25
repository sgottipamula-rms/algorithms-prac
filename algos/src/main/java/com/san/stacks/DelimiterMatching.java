package com.san.stacks;

import java.util.Stack;

public class DelimiterMatching {

    public void delimiterMatch(String str) {
        Stack<Character> stck = new Stack<>();

        for(char ch : str.toCharArray()) {

            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stck.push(ch);
                    break;
                case '}':
                    if(stck.pop() == '{')
                        System.out.println("delimiter found");
                    else
                        System.out.println("matching delimter not found");
                    break;
                case ')':
                    if(stck.pop() == '(')
                        System.out.println("delimiter found");
                    else
                        System.out.println("matching delimter not found");
                    break;
                case ']':
                    if(stck.pop() == '[')
                        System.out.println("delimiter found");
                    else
                        System.out.println("matching delimter not found");
                    break;
            }
        }

        if( ! stck.isEmpty())
            System.out.println("delimiters not found for all parenthesis");
    }
}
