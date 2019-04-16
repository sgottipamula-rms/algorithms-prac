package com.san.arrays;

public class FindUniqueInteger {

    public Integer find(int[] arr, int start, int end) {

        if(start>end)
            return -1;

        int mid = (start+end)/2;

        if((mid-1)<0)
        {
            if(arr[mid]!=arr[mid+1])
                return arr[mid];
        } else if(mid+1==arr.length) {
            if(arr[mid-1]!=arr[mid])
                return arr[mid];
        }else if((arr[mid]!=arr[mid-1])&&(arr[mid]!=arr[mid+1]))
            return arr[mid];

        int res = find(arr,start,mid-1);

        if(res==-1)
         res = find(arr,mid+1,end);

        return res;
    }

    public static void main(String[] args) {
        FindUniqueInteger findUniqueInteger = new FindUniqueInteger();
        int res = findUniqueInteger.find(new int[]{1,1,1,2,2,3,3,3,4,5,5,6,6,6,7,7},0,15);

        System.out.println(res);
    }
}
