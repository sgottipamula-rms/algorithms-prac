package com.san.trees;

public class BST {

    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    class ParentChildTuple {
        Node parent;
        boolean isCurrentLeftChild;
        Node child;

        public void setChild(Node child) {
            this.child = child;

            if(isCurrentLeftChild) {
                this.parent.left=this.child;
            } else {
                this.parent.right = this.child;
            }
        }
    }

    Node root;

    public void insert(int val) {

        Node newNode = new Node(val);

        if(root==null)
        {
            root = newNode;
            return;
        }

        Node currentNode = root;
        while(true)
        {
            Node parentNode=currentNode;
            if(newNode.val<=currentNode.val)
            {
                currentNode=currentNode.left;
                if(currentNode==null) {
                    parentNode.left = newNode;
                    break;
                }
            }
            else
            {
                currentNode=currentNode.right;
                if(currentNode==null) {
                    parentNode.right = newNode;
                    break;
                }
            }
        }
    }

    public ParentChildTuple find(int val) {
        Node currentNode=root;

        while(currentNode!=null)
        {
            if(val<currentNode.val)
            {
                currentNode=currentNode.left;
            }
            else if(val>currentNode.val)
            {
                currentNode=currentNode.right;
            }
            else if(val==currentNode.val)
            {
                return null;
            }
        }

        return null;
    }

    public void delete(int val) {

        Node parent = null;
        Node current = root;

        boolean wasLeftChild = false;
        while(true) {
            parent = current;

            if(val<current.val) {
                current = current.left;
                wasLeftChild=true;
                continue;
            }

            if(val>current.val) {
                current=current.right;
                wasLeftChild=false;
                continue;
            }

            if(val==current.val)
                break;
        }

        //deleteNode(parent,current, wasLeftChild);
    }

    private void setOnParent(Node parent, boolean currentWasLeftChild, Node node) {
        if(currentWasLeftChild) {
            parent.left=node;
        } else {
            parent.right=node;
        }
    }

    private void deleteNode(int val) {

        ParentChildTuple tuple = find(val);

        //if i am leaf node..just make parent point to null instead of me
        if(tuple.child.left==null && tuple.child.right==null) {
            tuple.setChild(null);
        }


        //if i have one child.. make parent point ot it
        if(tuple.child.left ==null || tuple.child.right==null) {
            if(tuple.child.left==null) {
                tuple.setChild(tuple.child.right);
            }

            if(tuple.child.right==null) {
                tuple.setChild(tuple.child.left);
            }
        }


        //i have two children ..find my in order successor
        Node successor = findInorderSuccessor(tuple.child.right);
        deleteNode(successor.val);
        tuple.child.val=successor.val;
    }

    private Node findInorderSuccessor(Node current) {

        int min = Integer.MAX_VALUE;

        while(current.val<=min && current.left!=null) {
            current = current.left;
        }

        return current;
    }

}
