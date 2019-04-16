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

    public boolean checkIfBalanced(Node node, BalancedCheck previousCheck) {

        if(previousCheck!=null) {

        } else {
            if(!previousCheck.IsBalanced)
                return false;
        }

        return false;
    }
}
