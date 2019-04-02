package com.san.recursion;

public class RecursiveMultiply {

    public int multiply(int x, int y) {

        if(y==0)
            return 0;

        return x+multiply(x,y-1);
    }

    public int multiplyme(int x, int y) {

        boolean hasNegatives = false;

        if(x<0) {
            x=(~x)+1; //turn it in to positive
            hasNegatives=!hasNegatives;
        }

        if(y<0) {
            y=(~y)+1; //turn in to positive
            hasNegatives=!hasNegatives;
        }

        int result = multiply(x,y);

        return hasNegatives?(~result)+1:result;
    }

    public static void main(String[] args) {
        System.out.println(new RecursiveMultiply().multiplyme(3,2));

    }
}
