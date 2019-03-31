package com.san.stacks;

import com.san.lists.SinglyLinkedList;

public class SinglyLinkedListStack {

    private final SinglyLinkedList singlyLinkedList;

    public SinglyLinkedListStack() {
        this.singlyLinkedList = new SinglyLinkedList();
    }

    public void push(int val) {
        singlyLinkedList.insertFirst(val);
    }


    public int pop() {

        return singlyLinkedList.deleteFirst();

    }

    public static void main(String[] args) {
        SinglyLinkedListStack stack = new SinglyLinkedListStack();


        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int pop=stack.pop();
        while(pop>0) {
            System.out.println(pop);
            pop=stack.pop();
        }

    }
}
