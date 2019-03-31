package com.san.stacks;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

public class SortMyStack {

    public Stack<Integer> unsortedStack;
    public Stack<Integer> sortedStack;

    public SortMyStack() {
        unsortedStack = new Stack<>();
        sortedStack = new Stack<>();
    }


    public void sort() {

        while( ! unsortedStack.isEmpty()) {

            Integer element = unsortedStack.pop();

            if (sortedStack.isEmpty()) {
                sortedStack.push(element);
                continue;
            }

            //asc so min most has to be on top
            //pop all elements lesser than element from sortedstack
            while(sortedStack.peek()<element) {
                unsortedStack.push(sortedStack.pop());
            }

            sortedStack.push(element);
        }
    }


    public static void main(String[] args) {
        SortMyStack sortMyStack = new SortMyStack();

        sortMyStack.unsortedStack.push(3);
        sortMyStack.unsortedStack.push(2);
        sortMyStack.unsortedStack.push(1);
        sortMyStack.unsortedStack.push(4);
        sortMyStack.unsortedStack.push(5);

        sortMyStack.sort();

        for(int i=0;i<5;i++)
            System.out.println(sortMyStack.sortedStack.pop());
    }
}
