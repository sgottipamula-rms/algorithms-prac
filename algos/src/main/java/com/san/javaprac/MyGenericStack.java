package com.san.javaprac;

import java.util.ArrayList;
import java.util.List;

public class MyGenericStack<T> {

    private final T[] stack;
    int max;
    int top=-1;

    public MyGenericStack(int max) {
        this.max = max;
        stack = (T[]) new Object[max];
    }

    public boolean isEmpty() {
        return stack.length==0;
    }

    public boolean isFull() {
        return top == max-1;
    }

    public void push(T val) {

        if(isFull())
            throw new IllegalArgumentException("stack full");

        stack[++top] = val;
    }

    public T pop() {
        if(isEmpty())
            throw new IllegalArgumentException("stack empty");


        return stack[top--];
    }
}
