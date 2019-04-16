package com.san.lists;

public class NthLastElement {
    Node head;

    public Node find(int n) {
        Node p1 = head;
        Node p2 = head;

        while (n > 0) {
            p2 = p2.getNext();
            n--;
        }

        while (p2.getNext() != null) {
            p2 = p2.getNext();
            p1 = p1.getNext();
        }

        return p1;
    }

}
