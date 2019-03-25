package com.san.stacks;

import java.util.Stack;

public class ReversePolishNotationEvaluation {

    //prefix = +37 (PN)
    //infix = 3+7
    //postfix = 37+ (RPN)



    public int eval(String expression) {

        Stack<Integer> operandStack = new Stack<>();

        for(char ch : expression.toCharArray()) {

            if(Character.isDigit(ch)) {
                operandStack.push(Character.getNumericValue(ch));
            } else {
                Integer rightOperand= operandStack.pop();
                Integer leftOperand = operandStack.pop();
                Integer result = 0;

                switch (ch) {
                    case '+':
                        result = leftOperand + rightOperand;
                        break;
                    case '-':
                        result = leftOperand - rightOperand;
                        break;
                    case '*':
                        result = leftOperand * rightOperand;
                        break;
                    case '/':
                        result = leftOperand / rightOperand;
                        break;
                }

                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }


    public static void main(String[] args) {
        ReversePolishNotationEvaluation reversePolishNotationEvaluation = new ReversePolishNotationEvaluation();
        System.out.println(reversePolishNotationEvaluation.eval("37+2*5/"));
    }
}
