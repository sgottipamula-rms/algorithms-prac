package com.san.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public void sort(int[] arr) {

        //create and init buckets
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0;i<3;i++) {
            buckets.add(i,new ArrayList<>());
        }

        for(int i=0;i<arr.length;i++) {
            List<Integer> bucketList = buckets.get(getBucket(i));
            bucketList.add(i);
        }


        for(int i=0;i<3;i++) {
            List<Integer> bucketList = buckets.get(i);
            Collections.sort(bucketList);

            for(Integer v : bucketList) {
                System.out.println(v);
            }
        }
    }

    //[b1: 0-3] [b2:4-6] [b3:7-9]
    public int getBucket(int i) {

        if(i>=0 && i<=3)
            return 0;

        if(i>=4 && i<=6)
            return 1;

        if(i>=7 && i<=9)
            return 2;

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{6,7,8,9,1,2,3,5,4};
        new BucketSort().sort(arr);
    }
}
