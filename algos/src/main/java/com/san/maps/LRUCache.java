package com.san.maps;

import java.util.*;

public class LRUCache {

    class Node {
        String key;
        Integer val;

        Node next;
        Node prev;

        public Node(String key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    class NodeList {

        Node first;
        Node last;

        public NodeList() {
            this.first = new Node(null,null);
            this.last = new Node(null,null);

            first.next=last;
            last.prev=first;
        }

        public void addFirst(Node node) {

            Node currentFirst = first.next;
            first.next=node;
            node.prev=first;
            node.next=currentFirst;
            currentFirst.prev=node;
        }

        public String removeLast() {

            Node currentLast = last.prev;
            currentLast.prev.next=last;
            last.prev = currentLast.prev;

            //nullify just to be sure
            currentLast.next=null;
            return currentLast.key;
        }

        public void deleteNode(Node node) {
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.prev=null;
            node.next=null;
        }
    }

    private final int maxSize;
    Map<String, Node> cache = new HashMap<>();
    NodeList nodeList = new NodeList();


    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(String key, Integer value) {

        Node nodeToBeInserted = new Node(key,value);

        if ( ! cache.containsKey(key)) {

            //evict from list & cache
            if (cache.size() == maxSize) {
                String lastNodeKey = nodeList.removeLast();
                cache.remove(lastNodeKey);
            }

            //insert into cache
            cache.put(key, nodeToBeInserted);
        } else {
            //delete from nodeList
            Node node = cache.get(key);
            nodeList.deleteNode(node);
        }

        //move entry to front
        nodeList.addFirst(new Node(key,value));
    }

    public Node get(String key) {

        //move it forward
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            nodeList.deleteNode(node);
            nodeList.addFirst(node);

            return node;
        }


        //evicted so return null
        return null;
    }
}
