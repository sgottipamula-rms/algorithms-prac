package com.san.stacks;

import java.util.Stack;

public class TwoStackQueue {

    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void enqueue(Integer val) {
        pushStack.push(val);
    }


    public int dequeue() {

        if(popStack.isEmpty()) {
            while ( ! pushStack.isEmpty())
                popStack.push(pushStack.pop());
        }

        return popStack.pop();
    }


    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();


        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);


        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }


}
