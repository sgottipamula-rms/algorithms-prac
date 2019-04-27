package com.san.sorting;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int start, int end) {

        if(start<end) {
            int partitionIndex = partition(arr,start,end);
            sort(arr,start,partitionIndex-1);
            sort(arr,partitionIndex+1,end);
        }
    }

    private int partition(int[] arr, int start, int end) {

        int pivot = arr[start];

        while(start<end) {
            while(arr[start]<pivot) {
                start++;
            }

            while(arr[end]>pivot) {
                end--;
            }

            if(start<end)
                swap(arr, start, end);
        }

        swap(arr, start, end);

        return end;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,7,8,9,1,2,3,5,4};
        new QuickSort().sort(arr,0,8);
        System.out.println(Arrays.toString(arr));
    }

}
