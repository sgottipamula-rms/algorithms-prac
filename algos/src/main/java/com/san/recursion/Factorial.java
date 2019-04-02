package com.san.recursion;

public class Factorial {

    //1,1,2,6,24,120..
    //f(0)=1
    //f(1)=1*f(0)
    //f(2)=2*f(1)
    //f(3)=3*f(2)
    //f(n)=n*f(n-1)

    private final int max=100;
    private final int[] memo=new int[max];

    private int generate(int i, int[] memo) {

        if(i==0)
            return 1;

        if(memo[i]==0)
            memo[i] = i*generate(i-1, memo);

        return memo[i];
    }

    public void sequence() {
        for(int i=0;i<max;i++) {
            System.out.println(generate(i, memo));
        }
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        factorial.sequence();
    }
}
