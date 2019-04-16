package com.san.trees;

public class FirstCommonAncestor {

    class Node {
        Integer value;
        Node leftChild;
        Node rightChild;

        public Node(Integer value, Node leftChild, Node rightChild) {
            this.value=value;
            this.leftChild=leftChild;
            this.rightChild=rightChild;
        }
    }

    public boolean commonAncestor(Node root, Integer targetValue1, Integer targetValue2) {

        if(root==null)
            return false;

        if(root.value==targetValue1 || root.value==targetValue2)
            return true;

        boolean leftValue = commonAncestor(root.leftChild,targetValue1,targetValue2);
        boolean rightValue = commonAncestor(root.rightChild,targetValue1,targetValue2);

        if(leftValue && rightValue) {
            System.out.println(root.value);
        }

        return leftValue || rightValue;
    }




    public void go() {
        Node node9 = new Node(9,null,null);
        Node node5 = new Node(5,null,null);
        Node node7 = new Node(7,null,null);
        Node node2 = new Node(2,null,null);

        Node node11 = new Node(11,node9,node5);
        Node node6 = new Node(6,node2,node11);
        Node node13 = new Node(13,node7,null);
        Node node8 = new Node(8,null,node13);

        Node node3 = new Node(3,node6,node8);
        commonAncestor(node3,2,5);
        //System.out.println(res);

    }

    public static void main(String[] args) {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor();
        firstCommonAncestor.go();
    }
}
