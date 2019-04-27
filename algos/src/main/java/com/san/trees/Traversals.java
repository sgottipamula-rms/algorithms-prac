package com.san.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals {

    class Node {
        Integer val;
        Node left;
        Node right;

        public Node(Integer val) {
            this.val = val;
        }
    }

    public void levelOrderTraversal(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while( ! queue.isEmpty()) {

            Node current = queue.remove();

            System.out.println(current.val);

            if(current.left != null)
                queue.add(current.left);

            if(current.right != null)
                queue.add(current.right);
        }

    }

    public void go() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.left=node2;
        node1.right=node3;

        node2.left=node4;
        node2.right=node6;
        node3.left=node7;
        node3.right=node8;

        node4.right=node5;


        levelOrderTraversal(node1);
    }


    public static void main(String[] args) {
        new Traversals().go();
    }
}
