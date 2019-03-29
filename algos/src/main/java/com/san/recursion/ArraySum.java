package com.san.recursion;

public class ArraySum {

    //given array [1,2,3,1,3,2] find number of combinations which yield sum 8

    public int makeSum(int[] arr, int sum, int index) {

        if(sum==0)
            return 1;

        if(index>=arr.length)
            return 0;


        //exclude the element at index
        int ways = makeSum(arr,sum,index+1);

        //include the element at index
        int remainder = sum-arr[index];
        if(remainder>=0)
            ways+=makeSum(arr,remainder,index+1);

        return ways;
    }


    public static void main(String[] args) {
        System.out.println(
                new ArraySum().makeSum(new int[]{1,2,3,1,1},3,0)
        );
    }
}
