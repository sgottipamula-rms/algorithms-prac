package com.san.javaprac;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class FinalModifier {

    private final int[] arr;
    private final List<Integer> list;

    public FinalModifier(int max) {
        arr = new int[max];
        list = new ArrayList<>();
    }
}
