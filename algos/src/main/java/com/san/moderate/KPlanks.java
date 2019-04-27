package com.san.moderate;

import java.util.HashSet;
import java.util.Set;

public class KPlanks {

    public Set<Integer> kplankLengths(int k, int shortPlankLength, int longPlankLength) {

        Set<Integer> result = new HashSet<>();


        for(int s=0; s<=k; s++) {
            int l = k-s;

            int length = s*shortPlankLength + l*longPlankLength;
            result.add(length);
        }


        return result;
    }
}
