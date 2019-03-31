package com.san.lists;

public class ReversePrintLinkedListValues {

    public void print(Node node) {

        if(node==null)
            return;

        //first print its next then print itself
        print(node.getNext());
        System.out.println(node.getVal());
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        ReversePrintLinkedListValues reversePrintLinkedListValues = new ReversePrintLinkedListValues();

        reversePrintLinkedListValues.print(list.getFirst());
    }
}
