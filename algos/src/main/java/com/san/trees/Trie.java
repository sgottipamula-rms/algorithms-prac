package com.san.trees;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    Node root;

    class Node {
        Map<Character,Node> nodeMap;
        boolean endOfWord;

        public Node() {
            //default empty node has no elements and is set to true for end of world
            nodeMap = new HashMap<>();
            endOfWord = true;
        }

        public Node addCharacterAndReturnItsNodeMap(Character ch) {
            nodeMap.putIfAbsent(ch, new Node());
            Node node = nodeMap.get(ch);
            endOfWord = false;

            return node;
        }

        public Node getCharactersChildren(Character ch) {
            return nodeMap.getOrDefault(ch, null);
        }

        public boolean amIAtEndOfWorld() {
            return endOfWord;
        }
    }


    public void insert(String str) {

        if(root ==null) {
            root = new Node();
        }

        Node current = root;
        for(Character ch : str.toCharArray()) {
            current = current.addCharacterAndReturnItsNodeMap(ch);
        }
    }

    public boolean prefixSearch(String str) {

        Node current = root;
        boolean result = true;
        for(Character ch : str.toCharArray()) {
            current = current.getCharactersChildren(ch);

            if(current==null) {
                result = false;
                break;
            }
        }

        return result;

    }

    public boolean wholeSearch(String str) {
        Node current = root;
        boolean result = true;

        for(Character ch : str.toCharArray()) {
            current = current.getCharactersChildren(ch);

            if(current==null) {
                result = false;
                break;
            }
        }

        //check if it forms full word
        if(result) {
            result = current.amIAtEndOfWorld() ? true : false;
        }

        return result;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("abc");
        trie.insert("abcl");
        trie.insert("cdf");
        trie.insert("abcd");
        trie.insert("lmn");


        System.out.println(trie.prefixSearch("ab"));
        System.out.println(trie.prefixSearch("lo"));

        System.out.println(trie.wholeSearch("lmn"));
        System.out.println(trie.wholeSearch("ab"));
        System.out.println(trie.wholeSearch("cdf"));
        System.out.println(trie.wholeSearch("gh"));
    }
}
