package com.san.arrays;

import sun.java2d.xr.MutableInteger;

public class Swapper {

    public void swap(MutableInteger a, MutableInteger b) {
        MutableInteger temp = new MutableInteger(a.getValue());
        a.setValue(b.getValue());
        b.setValue(temp.getValue());

        System.out.println(a.getValue());
        System.out.println(b.getValue());
    }

    public int summer(int[] arr)
    {
        int sum = 0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];

        return sum;
    }

    public static void main(String[] args) {
        Swapper swapper = new Swapper();
        MutableInteger a =new MutableInteger(10);
        MutableInteger b =new MutableInteger(20);
        swapper.swap(a,b);

        System.out.println(a.getValue());
        System.out.println(b.getValue());
    }
}
