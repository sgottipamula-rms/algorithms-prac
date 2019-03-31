package com.san.stacks;

import java.util.Stack;

public class SanStack<E> extends Stack<E> {

    private int max;

    public SanStack(int capacity) {
        super();
        this.max=capacity;
    }

    public boolean isFull() {
        return this.size()>=max;
    }
}
