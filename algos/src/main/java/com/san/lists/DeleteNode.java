package com.san.lists;

public class DeleteNode {
    Node head;

    public void deleteTail() {
        Node currentNode = head;

        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(null);

    }

    public void deleteNode(int val) {
        Node currentNode = head;

        while (currentNode.getVal() != val)
            currentNode = currentNode.getNext();

        currentNode.setVal(currentNode.getNext().getVal());
        currentNode.setNext(currentNode.getNext().getNext());

    }

}
