package com.san.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleInMemoryCacheTest {

    SimpleInMemoryCache simpleInMemoryCache = new SimpleInMemoryCache();

    @Test
    public void getAndSet() {
        assertEquals(Integer.MIN_VALUE, simpleInMemoryCache.get("a"));
        simpleInMemoryCache.set("a",1);
        assertEquals(1,simpleInMemoryCache.get("a"));
    }

    @Test
    public void increment() {
        simpleInMemoryCache.set("a",1);
        assertEquals(1,simpleInMemoryCache.get("a"));

        simpleInMemoryCache.increment("a");
        assertEquals(2,simpleInMemoryCache.get("a"));
    }

    @Test
    public void del() {
        simpleInMemoryCache.set("a",1);
        simpleInMemoryCache.set("b",2);
        simpleInMemoryCache.del("a");
        assertEquals(1,simpleInMemoryCache.cache.size());
        assertTrue(simpleInMemoryCache.cache.containsKey("b"));
    }

    @Test
    public void delvalue() {
        simpleInMemoryCache.set("a",1);
        simpleInMemoryCache.set("b",1);
        simpleInMemoryCache.set("c",2);
        assertEquals(3,simpleInMemoryCache.cache.size());
        assertEquals(2,simpleInMemoryCache.reverseCache.size());
        simpleInMemoryCache.delvalue(1);
        assertEquals(1,simpleInMemoryCache.cache.size());
        assertEquals(1,simpleInMemoryCache.reverseCache.size());
    }
}