package com.san.heap;

import javax.print.attribute.standard.Media;
import java.util.PriorityQueue;

public class MedianValue {

    // they dont have to be sorted but jst for eg.
    //[1,2,3,4,5]  median if odd number = middle i.e. 3
    //[1,2,3,4,5,6]  median = avg of middle two numbers (3+4)/2 = 3.5

    // lets consider this as a stream and at any point we want to give median
    // we need two heap...left is a maxheap [3,1,2] right is minheap[4,5]
    // median = whatever heap has more elements its top()
    //if even elements we get top from bothheaps and avg it
    //MaxHeap on left and MinHeap on right

    public double median(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)->y-x);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for(int i=0;i<arr.length; i++) {
            insertValue(arr[i],maxHeap,minHeap);
            rebalance(maxHeap,minHeap);
        }

        return getMedian(maxHeap,minHeap);
    }

    private double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if((maxHeap.size()+minHeap.size())%2!=0) {
            return maxHeap.size()>minHeap.size()? maxHeap.peek(): minHeap.peek();
        } else {
            return ((double)maxHeap.peek()+minHeap.peek())/2;
        }
    }

    private void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {

        if(maxHeap.size()>minHeap.size()) {
            if(maxHeap.size() - minHeap.size()>=2) {
                minHeap.add(maxHeap.remove());
            }
            return;
        }

        if(minHeap.size()>maxHeap.size()) {
            if(minHeap.size() - maxHeap.size()>=2) {
                maxHeap.add(minHeap.remove());
            }
        }
    }

    private void insertValue(int i, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {

        if(maxHeap.size()==0) {
            maxHeap.add(i);
            return;
        }

        if(i>maxHeap.peek()) {
            minHeap.add(i);
        } else {
            maxHeap.add(i);
        }
    }


    public static void main(String[] args) {
        MedianValue medianValue = new MedianValue();

        double res = medianValue.median(new int[]{5,4,3,2,1});

        System.out.println(res);
    }
}
