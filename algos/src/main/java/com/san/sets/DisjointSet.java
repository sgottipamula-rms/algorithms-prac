package com.san.sets;

import java.util.*;

public class DisjointSet {

    int cycles;
    int[] set = new int[8];  //0th is not used like in heaps

    //returns the set to which x belongs
    public int find(int x) {
        return set[x];
    }


    public void union(int x, int y) {

        //both uninitialzed
        if(set[x]==0 && set[y]==0) {
            set[x] = -1;
            set[y] = x;
            return;
        }

        //cycle..dont do anything as they already belong to same set
        if(set[x]==set[y]) {
            cycles++;
            return;
        }

        //x is parent
        if(set[x]<0) {
            set[y] = x;
            set[x]--; //decrement parent count
            return;
        }

        //x refers to parent
        if(set[x]>0) {
            set[y] = set[x];
            set[set[x]]--; //decrement parent count
            return;
        }

        //y is parent
        if(set[y]<0) {
            set[x] = y;
            set[y]--; //decrement parent count
            return;
        }

        //x refers to parent
        if(set[y]>0) {
            set[x] = set[y];
            set[set[y]]--; //decrement parent count
            return;
        }

    }


    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet();

        disjointSet.union(1,2);
        disjointSet.union(2,3);
        disjointSet.union(1,4);
        disjointSet.union(4,5);
        disjointSet.union(5,6);
        disjointSet.union(6,7);
        disjointSet.union(2,5);

        System.out.println("CYCLES:"+disjointSet.cycles);

        for(int i=1;i<=7;i++) {
            System.out.println("find("+i+"):"+disjointSet.find(i));
        }
    }

}
