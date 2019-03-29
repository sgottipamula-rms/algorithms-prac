package com.san.recursion;

public class TowersOfHanoi {

    // n-1 disks from A to B USING C
    /// nth disk from A to C
    // n-1 disks from B to C using A
    public void getSteps(int n, char A, char B, char C) {

        if(n==0)
            return;

        getSteps(n-1,A,C,B);
        System.out.println("Move disk from :"+A+"->"+C);
        getSteps(n-1,B,A,C);

    }


    public static void main(String[] args) {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();

        towersOfHanoi.getSteps(3,'A','B','C');
    }
}
