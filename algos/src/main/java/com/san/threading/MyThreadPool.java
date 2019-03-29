package com.san.threading;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool {

    private final AtomicInteger current;
    private final Runnable[] runnables;

    public MyThreadPool(int size) {
        this.current= new AtomicInteger();
        this.current.getAndSet(0);
        runnables = new Runnable[size];
    }

    public void add(Runnable runnable) {
        if(current.get()>=runnables.length)
            throw new IllegalArgumentException("threadpool full");

        runnables[current.get()] = runnable;
        current.getAndIncrement();
    }

    public void submit() {
        for(Runnable runnable : runnables)
            new Thread(runnable).start();
    }


    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(1);

        myThreadPool.add(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    System.out.println(i);
            }
        });

        myThreadPool.submit();
    }
}
