package com.san.sorting;

public class RadixSort {

    public int[] sort(int[] arr) {

        int maxdigits = getMaxDigitCount(arr);  //gets digit count from biggest element e.g. 1023 = 4
        CountingSort countingSort = new CountingSort();

        for(int i=1;i<=maxdigits;i++) {
            arr = countingSort.sortBasedOnNthDigit(arr,i);
        }

        return arr;
    }

    public int getMaxDigitCount(int[] arr) {

        int max=0;
        for(int i=0;i<arr.length;i++) {
            int current = getDigitsCount(arr[i]);

            if(current>max)
                max=current;
        }

        return max;
    }

    public int getDigitsCount(int num) {
        int count=0;

        while(num>0) {
            num = num / 10;
            count++;
        }

        return count;
    }



    public static void main(String[] args) {
        RadixSort rs = new RadixSort();

        int[] arr = new int[]{76,67,98,89,23,21,12,33,45,54};
        arr = rs.sort(arr);

        for(int i : arr)
            System.out.println(i);

    }
}
