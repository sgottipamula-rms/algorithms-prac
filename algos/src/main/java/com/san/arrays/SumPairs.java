package com.san.arrays;

import java.util.Arrays;

public class SumPairs {

    public void printPairsThatSumToAValue(int[] arr, int targetSum) {

        int left = 0;
        int right = arr.length-1;

        Arrays.sort(arr); //nlogn

        while(left<right) {

            int sum = arr[left] + arr[right];

            if(sum==targetSum) {
                System.out.println(arr[left]+","+arr[right]);
                left++;
                right--;
            }

            if(sum<targetSum) {
                //we need bigger value so increment left
                left++;
            }

            if(sum>targetSum) {
                //we need smaller value so decrement right
                right--;
            }

        }


    }


    public static void main(String[] args) {
        new SumPairs().printPairsThatSumToAValue(new int[]{-2, -1, 0, 3, 5, 6, 7, 9, 13, 14},8);
    }
}
