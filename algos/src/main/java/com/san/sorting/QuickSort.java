package com.san.sorting;

public class QuickSort {

    public void sort(int[] arr, int start, int end) {

        if(start<end) {
            int partition = partition(arr,start,end);
            sort(arr,start,partition-1);
            sort(arr,partition+1,end);
        }
    }

    private int partition(int[] arr, int start, int end) {

        int pivot=start;
        int pivotvalue = arr[pivot];

        int low=start+1;
        int high=end-1;

        while(low<high) {

            while(arr[low]<=pivotvalue)
                low++;

            while(arr[high]>pivotvalue)
                high--;

            if(low<high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }

        //at this point low is one value above pivot and high has value less than pivot
        //so swap pivot value with high
        int temp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp;

        return high;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,7,8,9,1,2,3,5,4};
        new QuickSort().sort(arr,0,8);
        System.out.println(arr);
    }

}
