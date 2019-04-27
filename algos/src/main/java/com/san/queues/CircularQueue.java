package com.san.queues;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class CircularQueue {

    int[] arr;
    int front = 0;
    int rear = 0;

    public CircularQueue(int size) {
        arr = new int[size+1];

        //sentinel
        arr[arr.length-1] = Integer.MIN_VALUE;
    }


    public void enqueue(int val) {

        //at sentinel wrap around
        if(arr[rear]==Integer.MIN_VALUE) {
            rear=0;

            if(rear==front) {
                throw new IllegalArgumentException("queue full");
            }
        }

        arr[rear++] = val;
    }

    public int dequeue() {

        //at sentinel wrap around
        if(arr[front]==Integer.MIN_VALUE) {
            front=0;

            if(rear==front) {
                throw new IllegalArgumentException("queue full");
            }
        }

        return arr[front++];
    }
}
