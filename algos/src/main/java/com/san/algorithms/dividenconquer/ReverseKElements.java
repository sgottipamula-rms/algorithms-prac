package com.san.algorithms.dividenconquer;

import java.util.Arrays;

public class ReverseKElements {

    public void reverseKElements(int[] arr, int k) {

        int start = 0;
        int end = k;
        while(end<arr.length) {
            reverse(arr, start, end);
            start=end+1;
            end=end+k+1;
        }

    }

    public void reverse(int[] arr, int start, int end) {
        while(start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        ReverseKElements reverseKElements = new ReverseKElements();
        reverseKElements.reverseKElements(arr, 3);

        System.out.println(Arrays.toString(arr));
    }
}
