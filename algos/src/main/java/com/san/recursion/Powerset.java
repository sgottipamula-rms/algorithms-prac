package com.san.recursion;

import java.util.*;

public class Powerset {

    //{}  = {}
    //{1}  = {},{1}
    //{1,2} = {}{1}{2}{1,2}...so basically powerset(1)+{head in powerset(1)}

    public Set<Set<Integer>> getPowerSets(List<Integer> originalSet) {
        Set<Set<Integer>> powerSet = new HashSet();

        if (originalSet.isEmpty()) {
            powerSet.add(new HashSet<Integer>());
            return powerSet;
        }


        Integer head = originalSet.get(0);
        Set<Set<Integer>> subPowerSets = getPowerSets(originalSet.subList(1, originalSet.size()));

        for (Set<Integer> subPowerSet : subPowerSets) {
            //my subpower sets are part of my powerset too
            powerSet.add(subPowerSet);

            //my head + my subpowersets are my actual powerset
            Set<Integer> temp = new HashSet<>();
            temp.add(head);
            temp.addAll(subPowerSet);
            powerSet.add(temp);

        }

        return powerSet;
    }

    public static void main(String[] args) {
        Powerset powerset = new Powerset();

        System.out.println(powerset.getPowerSets(Arrays.asList(1,2,3)));
    }
}
