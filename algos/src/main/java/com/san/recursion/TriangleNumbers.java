package com.san.recursion;

public class TriangleNumbers {

    //1,3,6,10,15
    //f(0)=0
    //f(1)=1 + f(0)
    //f(2)=2 + f(1)
    //f(3)=3 + f(2)

    private final int max=100;
    private final int[] memo=new int[max];

    private int generate(int i, int[] memo) {

        if(i==0)
            return 0;

        if(memo[i]==0)
            memo[i] = i+generate(i-1, memo);

        return memo[i];
    }

    public void sequence() {
        for(int i=0;i<max;i++) {
            System.out.println(generate(i, memo));
        }
    }

    public static void main(String[] args) {

        TriangleNumbers triangleNumbers = new TriangleNumbers();
        triangleNumbers.sequence();
    }
}
