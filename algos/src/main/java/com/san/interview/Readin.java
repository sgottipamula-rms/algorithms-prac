package com.san.interview;

import java.util.*;

public class Readin {
    public static void main(String[] args) {
//        int max = maxDifference(Arrays.asList(new Integer[]{
//                7,
//                2,
//                3,
//                10,
//                2,
//                4,
//                8,
//                1}));
//
//        System.out.println(max);

        long max = maxPoints(Arrays.asList(new Integer[]{
                5,
                1,
                1,
                1,
                2,
                3
        }));

        System.out.println(max);
    }

    public static int maxDifference(List<Integer> a) {
        int maxdifference = -1;

        if(a.size()>1) {

            for (int i = 1; i < a.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (a.get(i) > a.get(j)) {
                        int diff = a.get(i) - a.get(j);
                        if (diff > maxdifference) {
                            maxdifference = diff;
                        }
                    }
                }
            }
        }

        return maxdifference;

    }

    public static long maxPoints(List<Integer> elements) {

        int maxPoints=0;

        for(int i=0;i<elements.size();i++) {

            Map<Integer,Integer> map = getHashMapFromList(elements);

            int total=0;

            int current = elements.get(i);
            total+=map.get(current);
            map.remove(current);
            map.remove(current+1);
            map.remove(current-1);


            while(map.size()>0) {
                current = map.keySet().iterator().next();
                total+=map.get(current);
                map.remove(current);
                map.remove(current+1);
                map.remove(current-1);
                total+=current;

            }

            if(total>maxPoints)
                maxPoints=total;
        }

        return maxPoints;
    }

    public static Map<Integer,Integer> getHashMapFromList(List<Integer> list) {
        Map<Integer,Integer> map = new HashMap<>();

        for(Integer i : list) {
            Integer frequency = map.getOrDefault(i,0);
            map.put(i,++frequency);
        }

        return map;
    }

}
