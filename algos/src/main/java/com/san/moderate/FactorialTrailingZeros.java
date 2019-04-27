package com.san.moderate;

public class FactorialTrailingZeros {

    public int getTrailingZerosForFactorial(int num) {

        int totalFactor2Count = 0;
        int toralFactor5Count = 0;

        for(int i=1;i<=num;i++) {

            totalFactor2Count += getFactorCount(i,2);
            toralFactor5Count += getFactorCount(i,5);
        }

        return Math.min(toralFactor5Count,totalFactor2Count);
    }

    private int getFactorCount(int i, int base) {

        int count = 0;

        while(i%base==0) {
            count++;

            i=i/base;
        }

        return count;
    }

    public static void main(String[] args) {
        FactorialTrailingZeros factorialTrailingZeros = new FactorialTrailingZeros();

        int retta = factorialTrailingZeros.getTrailingZerosForFactorial(19);

        System.out.println(retta);
    }
}
