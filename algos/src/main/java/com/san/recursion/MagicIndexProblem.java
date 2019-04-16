package com.san.recursion;

public class MagicIndexProblem {

    //basically binary search problem instead of search we return at i=arr[i]

    public int binarySearch(int arr[], int low, int high)
    {
        if(low>high)
            return -1;

        int mid = (low + high)/2;
        if(mid == arr[mid])
            return mid;
        if(mid > arr[mid])
            return binarySearch(arr, (mid + 1), high);
        else
            return binarySearch(arr, low, (mid -1));

    }

}
