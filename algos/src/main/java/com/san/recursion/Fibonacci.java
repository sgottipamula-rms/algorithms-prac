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
    public int fibonacciTopDownWithMemo(int n, int[] memo) {

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


    public int fibonacciBottomUpWithMemo(int n) {

        if(n==0)
            return 0;
        if(n==1)
            return 1;

        int[] memo = new int[n+1];
        memo[0]=0;
        memo[1]=1;

        for(int i=2;i<=n;i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];

    }



    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();
        int[] memo = new int[20];

//        for(int i=0;i<20;i++) {
//            System.out.println(fibonacci.fibonacciTopDownWithMemo(i,memo));
//        }

        for(int i=0;i<20;i++) {
            System.out.println(fibonacci.fibonacciBottomUpWithMemo(i));
        }

    }
}
