package com.san.trees;

import java.util.Random;

public class BSTWithGetRandomNode {

    class Node {
        Integer val;
        Node left;
        Node right;
        Integer size;
    }


    public Node getRandomNode(Node node) {

        Random rand = new Random();
        Integer randi = rand.nextInt(node.size); //0 to nodesize

        if(randi==node.size)
            return node;

        //do some null checks
        Node lowerSizeNode = node.left.size<node.right.size?node.left: node.right;
        Node biggerSizeNode = node.left.size>node.right.size?node.right: node.left;

        if(randi<lowerSizeNode.size)
            return getRandomNode(lowerSizeNode);
        else
            return getRandomNode(biggerSizeNode);
    }
}
