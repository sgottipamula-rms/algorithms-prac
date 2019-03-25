package com.san.stacks;

public class MyStack {

    private int top = -1;
    private int size;
    private int[] arr;

    public MyStack() {
        this(10);
    }

    public MyStack(int size) {
        this.size = size;
        this.arr = new int[size];
    }


    public int pop() {

        if(top >= 0) {
            return arr[top--];
        } else {
            throw new IllegalArgumentException("stack empty");
        }
    }

    public void push(int num) {

        if(top < size) {
            arr[++top] = num;
        } else {
            throw new IllegalArgumentException("stack full");
        }
    }


}
