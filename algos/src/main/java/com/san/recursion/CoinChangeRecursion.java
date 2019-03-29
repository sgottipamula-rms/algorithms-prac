package com.san.recursion;

public class CoinChangeRecursion {


    public long makeChange(int[] coins, int money, int index) {

        if(money==0)
            return 1;   //exact change possible so return 1


        if(index>=coins.length)
            return 0;


        int ways=0;
        int remainder = money;
        while(remainder>=0) {
            //make remainder money with remaining coins
            ways += makeChange(coins,remainder,index+1);
            remainder -= coins[index];
        }

        return ways;
    }


    public static void main(String[] args) {
        CoinChangeRecursion coinChangeRecursion = new CoinChangeRecursion();

        int arr[] = new int[]{10,5,2,1};
        System.out.println(
        coinChangeRecursion.makeChange(arr,27,0)
        );

    }
}
