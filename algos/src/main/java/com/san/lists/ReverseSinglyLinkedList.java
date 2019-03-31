package com.san.lists;

import com.san.stacks.ReversePolishNotationEvaluation;

public class ReverseSinglyLinkedList {

    public SinglyLinkedList reverseSinglyLinkedList(SinglyLinkedList list) {

        //f(5)->4->3->2->1
        // to f(1)->2->3->4->5 which is exactly same as 5<-4<-3<-2<-f(1)

        //simple option is to push in to stack and pop from stack in to return list

        //below is 3 pointer option
        //at current make its next point to prev
        //advance prev to current and current to next
        Node prev=null;
        Node current=list.getFirst();
        Node next=null;
        while(current!=null) {
            next=current.getNext();
            current.setNext(prev);
            prev=current;
            current=next;
        }

        //reset first
        list.setFirst(prev);

        return list;
    }

    public void reverseListUsingRecursion(Node current, SinglyLinkedList list) {

        if(current==null)
            return;

        if(current.getNext()==null) {
            list.setFirst(current);
            return;
        }

        Node next = current.getNext();
        reverseListUsingRecursion(next, list);
        next.setNext(current);
        current.setNext(null);
    }

    public static void main(String[] args) {
        ReverseSinglyLinkedList reverseSinglyLinkedList = new ReverseSinglyLinkedList();

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        reverseSinglyLinkedList.reverseListUsingRecursion(list.getFirst(), list);

        list.display();
    }
}
