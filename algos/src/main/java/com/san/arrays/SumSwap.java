package com.san.arrays;

import java.util.*;

public class SumSwap {

    public void swap(int[] a, int[] b) {

        int diff = (sum(a) - sum(b)) / 2;
        Set<Integer> bset = new HashSet(Arrays.asList(b));

        for(int i : a) {
            if(bset.contains(Math.abs(a[i]-diff))) {
                System.out.println(a[i]+","+Math.abs(a[i]-diff));
            }
        }

    }

    public int sum(int[] a) {

        int sum = 0;

        for(int i : a) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        new SumSwap().swap(new int[]{4,1,2,1,1,2}, new int[]{3,6,3,3});
    }


}
