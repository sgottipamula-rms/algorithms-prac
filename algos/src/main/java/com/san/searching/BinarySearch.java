package com.san.searching;

public class BinarySearch {

    public int search(int[] arr, int start, int end, int num) {

        int mid = (end+start)/2;

        if(num == arr[mid])
            return mid;

        if(start==end)
            return -1;

        if(num<arr[mid])
            return search(arr, start,mid-1,num);
        else if(num>arr[mid])
            return search(arr,mid+1,end,num);

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int index = binarySearch.search(new int[]{1,2,3,4,5,6,7,8,9}, 0 ,8, 61);
        System.out.println(index);
    }

}
