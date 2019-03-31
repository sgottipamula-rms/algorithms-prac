package com.san.searching;

import java.util.BitSet;

public class SortedArrayUnknownSizeSearch {


    public int search(int[] arr, int start, int end, int num) {

        int mid = (end+start)/2;


        if(num == arr[mid])
            return mid;

        if(start==end)
            return -1;

        if(num<arr[mid])
            return search(arr, start,mid-1,num);
        else if(num>arr[mid])
            return search(arr,mid+1,end,num*2);

        return -1;




    }
}
