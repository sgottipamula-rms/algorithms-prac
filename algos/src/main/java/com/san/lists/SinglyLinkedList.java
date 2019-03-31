package com.san.lists;

public class SinglyLinkedList {

    private Node first;

    public Node getFirst() {
        return this.first;
    }

    public void setFirst(Node node) {
        this.first=node;
    }

    public void insertFirst(int val) {

        Node n = new Node();
        n.setVal(val);

        if(first==null) {
            first=n;
            n.setNext(null);
            return;
        }

        n.setNext(first);
        first=n;
    }

    public int deleteFirst() {

        int val = -1;

        if(first==null)
            return val;


        val=first.getVal();
        if(first.getNext()==null) {
            first = null;
        } else {
            first = first.getNext();
        }

        return val;
    }

    public void display() {

        Node current=first;

        while(current!=null) {
            System.out.println(current.getVal());
            current = current.getNext();
        }
    }
}
