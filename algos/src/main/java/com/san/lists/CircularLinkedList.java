package com.san.lists;

public class CircularLinkedList {

    Node head;

    public Node findBeginingOfLoop() {
        Node tortoise = head;
        Node hare = head;

        while (true) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
            if (tortoise == hare)
                break;
        }

        tortoise = head;

        while (true) {
            tortoise = tortoise.getNext();
            hare = hare.getNext();
            if (tortoise == hare)
                break;
        }
        return hare;
    }

}
