package com.san.recursion;

public class Fibonacci {

    public int getNumber(int n) {

        if(n==0) {
            return 0;
        }

        if(n==1) {
            return 1;
        }

        return getNumber(n-1) + getNumber(n-2);
    }

    //with memoization
    public int getNumberWithMemo(int n, int[] memo) {

        if(n==0) {
            return 0;
        }

        if(n==1) {
            return 1;
        }

        if(memo[n] == 0)
            memo[n] = getNumber(n-1) + getNumber(n-2);

        return memo[n];
    }



    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();
        int[] memo = new int[20];

        for(int i=0;i<20;i++) {
            System.out.println(fibonacci.getNumberWithMemo(i,memo));
        }

    }
}
