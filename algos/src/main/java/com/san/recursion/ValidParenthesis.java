package com.san.recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesis {

    PermutationsOfAString permutationsOfAString = new PermutationsOfAString();

    public Set<String> getValidParenthesisCombinations(int num) {
        String str = "";
        for (int i = 0; i < num; i++)
            str += "()";

        Set<String> listOfParenthesis = new HashSet();
        for (String word : permutationsOfAString.getPermutations(str)) {
            if (isValidParenthesis(word))
                listOfParenthesis.add(word);
        }

        return listOfParenthesis;
    }

    public boolean isValidParenthesis(String str) {
        Stack<Character> stackOfParenthesis = new Stack();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stackOfParenthesis.push(str.charAt(i));
                continue;
            }

            if (str.charAt(i) == ')') {
                if (stackOfParenthesis.isEmpty())
                    return false;
                else
                    stackOfParenthesis.pop();
            }
        }

        return stackOfParenthesis.isEmpty();
    }

    public static void main(String[] args) {

        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.getValidParenthesisCombinations(5));
    }
}
