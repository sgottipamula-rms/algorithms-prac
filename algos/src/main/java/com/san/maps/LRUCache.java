package com.san.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int size;

    private LRUCache(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static <K, V> LRUCache<K, V> newInstance(int size) {
        return new LRUCache<K, V>(size);
    }
}
