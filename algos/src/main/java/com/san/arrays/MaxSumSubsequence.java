package com.san.arrays;

public class MaxSumSubsequence {

    public void maxSumSubsequence(int[] arr) {

        int[] sumarr = new int[arr.length];

        for(int i=0;i<arr.length;i++) {
            int prevmax = i==0 ? Integer.MIN_VALUE : sumarr[i-1];
            sumarr[i] = Math.max(arr[i],arr[i] + prevmax);
        }

        //find max & max index
        int maxvalue=Integer.MIN_VALUE;
        int maxindex=0;
        for(int i = 0; i<sumarr.length;i++) {

            if(sumarr[i]>maxvalue) {
                maxvalue=sumarr[i];
                maxindex=i;
            }
        }


        System.out.println("MAX SUM"+maxvalue);

        //calculate l and r
        int r=maxindex;
        int l=maxindex;
        int tot=maxvalue;
        while(l>=0) {
            tot = tot - arr[l];

            if(tot==0)
                break;
            else
                l--;

        }


        while(l<=r) {
            System.out.println(arr[l++]);
        }
    }

    public static void main(String[] args) {
        new MaxSumSubsequence().maxSumSubsequence(new int[]{2,-8,3,-2,4,-10});
    }
}
