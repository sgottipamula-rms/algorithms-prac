package com.san.recursion;

import java.util.*;

public class Powerset {

    public Set<Set<Integer>> getPowerSets(Set<Integer> originalSet) {
        Set<Set<Integer>> powerSet = new HashSet();

        if (originalSet.isEmpty()) {
            powerSet.add(new HashSet<Integer>());
            return powerSet;
        }

        List<Integer> listOfOriginalSet = new ArrayList(originalSet);
        Integer head = listOfOriginalSet.get(0);
        Set<Set<Integer>> remainingPowerSets = getPowerSets(new HashSet<>(listOfOriginalSet.subList(1, listOfOriginalSet.size())));

        for (Set<Integer> remainingSet : remainingPowerSets) {
            //add remaining sets
            powerSet.add(remainingSet);

            //add remaining sets combined with head
            Set<Integer> temp = new HashSet<>();
            temp.add(head);
            temp.addAll(remainingSet);
            powerSet.add(temp);

        }

        return powerSet;
    }

    public static void main(String[] args) {
        Powerset powerset = new Powerset();

        System.out.println(powerset.getPowerSets(new HashSet<Integer>(Arrays.asList(1,2,3))));
    }
}
