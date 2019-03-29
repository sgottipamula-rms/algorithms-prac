package com.san.queues;

import java.util.LinkedList;
import java.util.Queue;

public class SuperFibonacci {

    //generate super fibonacci sequence where each element
    // is sum of k elements before
    // i will give an arbitrary x if the sequence is greater than this return


    public void generate(int k, int[] arr, int x) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<k;i++) {
            queue.add(arr[i]);

            System.out.println(arr[i]);
        }



        int current=((LinkedList<Integer>) queue).peekLast();
        while(current<x) {
            int sum=0;
            for(int i=0;i<k;i++)
                sum+=((LinkedList<Integer>) queue).get(i);

            queue.remove();
            queue.add(sum);
            current=sum;
            System.out.println(sum);
        }
    }


    public static void main(String[] args) {
        SuperFibonacci superFibonacci = new SuperFibonacci();

        superFibonacci.generate(3, new int[]{0,1,1}, 1000);
    }

}
