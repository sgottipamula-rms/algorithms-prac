package com.san.sorting;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {

    public void sort(int[] arr) {

        //init counts arr
        List<Integer>[] counts = new List[10];
        for(int i=0;i<10;i++) {
            counts[i] = new ArrayList<>();
        }

        for(int i=0;i<arr.length;i++) {
            int val = arr[i];
            counts[val].add(val);
        }

        int r=0;
        for(int i=0;i<counts.length;i++) {
            for(int j : counts[i]) {
                arr[r++]=j;
            }
        }

    }

    public int[] sortBasedOnNthDigit(int[] arr, int n) {
        //init counts arr
        List<Integer>[] counts = new List[10];
        for(int i=0;i<10;i++) {
            counts[i] = new ArrayList<>();
        }

        for(int i=0;i<arr.length;i++) {
            int val = getNthDigitFromLast(arr[i],n);
            counts[val].add(arr[i]);
        }

        int[] result = new int[arr.length];
        int r=0;
        for(int i=0;i<counts.length;i++) {
            for(int j : counts[i]) {
                result[r++]=j;
            }
        }

        return result;
    }

    private int getNthDigitFromLast(int num, int n) {

        double remainder = num % (Math.pow(10,n));
        Double nthDigit = remainder / (Math.pow(10,n-1));

        return nthDigit.intValue();
    }



    public static void main(String[] args) {
        int[] arr = new int[]{61,73,82,90,14,27,36,57,48};

        new CountingSort().sortBasedOnNthDigit(arr,2);

        for(int i : arr)
            System.out.println(i);
    }
}
