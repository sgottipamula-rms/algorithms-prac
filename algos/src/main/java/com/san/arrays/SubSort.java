package com.san.arrays;

public class SubSort {

    public void printsubsortIndexes(int[] arr) {

        int cmin=0;
        int cmax=0;

        //find cmin
        int i=0;
        while((i+1<=arr.length-1) && arr[i]<=arr[i+1])
            i++;
        cmin=i+1;

        //find cmax
        i=arr.length-1;
        while((i-1>=0) && arr[i-1]<=arr[i])
            i--;
        cmax=i-1;

        System.out.println(cmin);
        System.out.println(cmax);

        //find min value
        int minvalue=arr[cmin];
        for(int j=cmin;j<=arr.length-1;j++) {
            if(arr[j]<=minvalue) {
                minvalue=arr[j];
            }
        }

        //find maxvalue
        int maxvalue=arr[cmax];
        for(int j=cmax;j>=0;j--) {
            if(arr[j]>=maxvalue) {
                maxvalue = arr[j];
            }
        }

        System.out.println(minvalue);
        System.out.println(maxvalue);

        //where should we place minvalue
        //int left = binarysearchForPlace(arr,0,cmin);
        //int right = binarysearchForPlace(arr,cmax,arr.length-1);
    }


    public static void main(String[] args) {
        new SubSort().printsubsortIndexes(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19});
    }
}


