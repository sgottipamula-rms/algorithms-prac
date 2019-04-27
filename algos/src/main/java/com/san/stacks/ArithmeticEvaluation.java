package com.san.stacks;

import com.sun.deploy.util.StringUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArithmeticEvaluation {

    public int eval(String exp) {

        Deque<Integer> operands = new LinkedList<>();
        Queue<String> operators = new LinkedList<>();


        int i=0;
        while(i<exp.length()) {

            String stringch = exp.charAt(i)+"";

            if(isNumeric(stringch)) {
                operands.addLast(Integer.parseInt(stringch));
            } else {
                //has to be operator

                if(amIHigher(stringch)) {
                    //evaluate immediatly
                    i++;
                    operands.addLast(Integer.parseInt(exp.charAt(i)+""));
                    int right = operands.removeLast();
                    int left = operands.removeLast();
                    int result = evaluate(left,right, stringch);
                    operands.addLast(result);
                } else {
                    operators.add(stringch);
                }
            }

            i++;
        }


        //evaluate deque
        while(operands.size()>=2) {
            int result = evaluate(operands.removeFirst(), operands.removeFirst(), operators.remove());
            operands.addFirst(result);
        }

        return operands.remove();

    }

    public int evaluate(int left, int right, String operator) {

        switch (operator) {
            case "*":
                return left * right;
            case "/":
                return left/right;
            case "+":
                return left + right;

            case "-":
                return left - right;
        }

        return 0;
    }

    private boolean amIHigher(String operator) {

        if(operator.equals("*") || operator.equals("/"))
            return true;

        return false;
    }


    public boolean isNumeric(String ch) {

        try {
            int val = Integer.parseInt(ch);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }


    public static void main(String[] args) {
        String exp = "2-6-7*8/2+5";

        System.out.println(new ArithmeticEvaluation().eval(exp));
    }
}
