package com.san.searching;

import java.util.Arrays;

public class SortedRotatedArray {

    public int getPivotIndex(int[] arr, int start, int end) {
        //in whole array values are ascending except this pivot value where it breaks this
        // e.g. 789123456 ....see after 9 and 1.. 1 is pivot value

        int mid = (start+end)/2;

        if(arr[mid] > arr[mid+1])
            return mid+1;  //pivot value found


        // pivot should be in the side where ascending condition isnt satisfying
        if(arr[start] > arr[mid])
            return getPivotIndex(arr,start,mid);

        if(arr[mid+1] > arr[end])
            return getPivotIndex(arr,mid+1,end);

        return -1;
    }


    public int binarySearch(int[] arr, int num) {

        int pivotIndex = getPivotIndex(arr,0,arr.length-1);

        System.out.println(pivotIndex);

        int findIndex = Arrays.binarySearch(arr,0, pivotIndex - 1, num);

        if(findIndex < 0)
            findIndex = Arrays.binarySearch(arr,pivotIndex, arr.length-1, num);

        return findIndex<0 ? -1 : findIndex;
    }

    public static void main(String[] args) {
        SortedRotatedArray sortedRotatedArray = new SortedRotatedArray();

        System.out.println(sortedRotatedArray.binarySearch(new int[]{7,8,9,1,2,3,4,5,6},10));
    }
}
