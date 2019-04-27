package com.san.trees;

public class BalancedTreeTest {

    class Node {
        Integer val;
        Node leftChild;
        Node rightChild;
    }

    class BalancedCheck {
        boolean IsBalanced;
        Integer depth;
    }

    public boolean checkIfBalanced(Node node, int minmin, int maxmin, int minmax, int maxmax) {

        if(node==null)
            return true;

        //if(maxmin<node.val<=maxmin)

        return false;

    }
}
