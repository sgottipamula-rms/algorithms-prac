package com.san.stacks;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class SetOfStacks {
    private int threshold;
    List<SanStack<Integer>> stackList;

    public SetOfStacks(int threshold) {
        this.stackList = new ArrayList<>();
        this.threshold = threshold;
    }

    public void push(Integer val) {

        //if full create new stack
        SanStack<Integer> last = getLastStack();
        if(last.isFull()) {
            stackList.add(new SanStack<>(threshold));
            last = getLastStack();
        }

        last.push(val);
    }

    public int pop() {

        //if empty delete this stack from stacklist
        SanStack<Integer> last = getLastStack();

        if(last.isEmpty()) {
            stackList.remove(stackList.size()-1);
            last = getLastStack();
        }

        return last.pop();
    }

    public SanStack<Integer> getLastStack() {

        if(stackList.isEmpty())
            stackList.add(new SanStack(threshold));

        return stackList.get(stackList.size()-1);
    }


    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(1);

        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);


        for(int i=0;i<5;i++)
            System.out.println(setOfStacks.pop());
    }
}
