package com.san.javaprac;

import java.util.HashSet;

public class SetOperations {

    public void union(HashSet<Integer> s1, HashSet<Integer> s2) {

        //UNION
        s1.addAll(s2);
        System.out.println(s1);
    }

    public void intersection(HashSet<Integer> s1, HashSet<Integer> s2) {

        //UNION
        s1.retainAll(s2);
        System.out.println(s1);
    }

    public void minus(HashSet<Integer> s1, HashSet<Integer> s2) {

        //UNION
        s1.removeAll(s2);
        System.out.println(s1);
    }

    public static void main(String[] args) {

        SetOperations setOperations = new SetOperations();

        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(5);
        set2.add(6);

        //setOperations.union(set1, set2);
        setOperations.minus(set1, set2);
    }
}
