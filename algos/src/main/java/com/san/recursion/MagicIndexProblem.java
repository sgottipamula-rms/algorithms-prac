package com.san.recursion;

public class MagicIndexProblem {

    //basically binary search problem instead of search we return at i=arr[i]

    public int binarySearch(int arr[], int low, int high)
    {
        if(high >= low)
        {
            /* low + (high - low)/2; */
            int mid = (low + high)/2;
            if(mid == arr[mid])
                return mid;
            if(mid > arr[mid])
                return binarySearch(arr, (mid + 1), high);
            else
                return binarySearch(arr, low, (mid -1));
        }

        /* Return -1 if there is
           no Fixed Point */
        return -1;
    }

}
