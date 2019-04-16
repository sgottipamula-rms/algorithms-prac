package com.san.lists;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SkipList {

    class Node{
        Integer value;
        Node prev;
        Node next;
        Node above;
        Node below;
    }

    class NodeList {
        Node first;
        Node last;

        public NodeList() {
            first = new Node();
            last = new Node();

            first.value=Integer.MIN_VALUE;
            last.value = Integer.MAX_VALUE;
            first.next=last;
            last.prev=first;
        }


        BitSet bitSet = new BitSet();
    }

    List<NodeList> skipLists = new ArrayList<>();

    public SkipList() {
        skipLists.add(new NodeList());
    }


    private boolean shouldIPromote() {

        //returns 0 or 1...if 0 return true 50% probability
        return ThreadLocalRandom.current().nextInt(0,2)==0;
    }

    public void insert(Integer val) {

        Node previousLevelNode = new Node();
        for(int i=0;i<skipLists.size();i++) {

            NodeList nodeList = skipLists.get(i);

            Node current = nodeList.first;
            while(current.value<val)
                current=current.next;

            Node node = new Node();
            node.value=val;
            node.next=current;
            node.prev=current.prev;
            current.prev.next=node;
            current.prev=node;
            node.below=previousLevelNode;
            previousLevelNode.above=node;

            previousLevelNode=node;

            if( ! shouldIPromote())
                break;
        }

    }


    public boolean find(Integer val) {

        Node current = skipLists.get(skipLists.size()-1).first;

        while(true) {

            while (current.value < val)
                current = current.next;

            if(current.value==val){
                System.out.println("found");
                return true;
            }

            //last level
            if(current.below==null) {
                return false;
            }

            //go down level now
            current = current.prev;
            current = current.below;
        }
    }

}
