package com.san.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class LinkedListNode{
        int val;
        LinkedListNode next;
        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

    public static LinkedListNode listAdd(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        } else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }

    public static void printList(LinkedListNode head) {
        LinkedListNode iter = head;
        while(iter != null){
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }




    static LinkedListNode removeAll(int n, LinkedListNode head){

        while(head.val==n) {
            head=head.next;
        }

        LinkedListNode current = head;

        while(current != null) {
            //tail
            if(current.next.next==null) {
                if(current.next.val==n) {
                    current.next=null;
                }
            }

            if(current.val == n) {
                current.val = current.next.val;
                current.next = current.next.next;
            }
        }

        return head;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int size = in.nextInt();
        int i, item;
        LinkedListNode head = null, tail = null;
        for(i = 0; i < size; i++) {
            item = in.nextInt();
            tail = listAdd(head, tail, item);
            if (i == 0) {
                head = tail;
            }
        }
        head = removeAll(n, head);
        printList(head);
    }
}
