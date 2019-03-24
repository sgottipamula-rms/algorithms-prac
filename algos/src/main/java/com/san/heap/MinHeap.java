package com.san.heap;

import java.util.Arrays;

public class MinHeap {

    public int[] heap;
    public int heapLastElementIndex;

    public MinHeap(int size) {
        heap = new int[size+1];
    }

    public boolean hasElements() {
        return heapLastElementIndex < 1;
    }

    public void insert(int val) {

        if(heapLastElementIndex ==heap.length-1)
            throw new IllegalArgumentException("Heap maxed");


        heapLastElementIndex++;
        heap[heapLastElementIndex] = val;

        if(heapLastElementIndex==1)
            return;

        //bubble up
        int currentIndex = heapLastElementIndex;
        int parentIndex = currentIndex/2;
        while(heap[parentIndex] > heap[currentIndex]) {
            int temp = heap[parentIndex];
            heap[parentIndex] = heap[currentIndex];
            heap[currentIndex] = temp;

            currentIndex = parentIndex;
            parentIndex = currentIndex/2;
        }
    }

    public int remove(int index) {

        if(index>heapLastElementIndex)
            return -1;

        //stick last element in the removed index slot
        int valueRemoved = heap[index];
        heap[index] = heap[heapLastElementIndex];
        heap[heapLastElementIndex] = 0;
        heapLastElementIndex--;

        //bubble down
        int currentIndex = index;
        while(true) {

            int leftChildIndex = 2*currentIndex;
            int rightChildIndex = (2*currentIndex) + 1;

            if(leftChildIndex>heapLastElementIndex)
                break;

            if (heap[currentIndex] >= heap[leftChildIndex]) {
                int temp = heap[leftChildIndex];
                heap[leftChildIndex] = heap[currentIndex];
                heap[currentIndex] = temp;

                currentIndex=leftChildIndex;
                continue;
            }

            if(rightChildIndex>heapLastElementIndex)
                break;

            if (heap[currentIndex] >= heap[rightChildIndex]) {
                int temp = heap[rightChildIndex];
                heap[rightChildIndex] = heap[currentIndex];
                heap[currentIndex] = temp;

                currentIndex=rightChildIndex;
                continue;
            }

            break;
        }

        return valueRemoved;
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);


        System.out.println(Arrays.toString(minHeap.heap));

//        minHeap.remove(2);
//        System.out.println(Arrays.toString(minHeap.heap));


        for(int i=1; i<=5;i++)
            System.out.println(minHeap.remove(1)); //this will always be in ascending order

    }
}
