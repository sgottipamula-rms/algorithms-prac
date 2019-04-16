package com.san.queues;

import java.util.PriorityQueue;

public class PriorityQueuePrac {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        while( ! queue.isEmpty())
            System.out.println(queue.remove());
    }
}
