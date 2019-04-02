package com.san.threading;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeMethodExecution {
    private Object lockObject1 = new Object();
    private Object lockObject2 = new Object();

    public void first() {
        synchronized (lockObject1) {
            System.out.println("first");
            lockObject1.notify();
        }
    }

    public void second() {
        synchronized (lockObject1) {
            System.out.println("second");
            lockObject2.notify();
        }
    }

    public void third() {
//        synchronized (lockObject) {
//            System.out.println("third");
//            lockObject.notify();

    }


    public void runMyThreads() throws Exception {

        Future f1,f2,f3;
        do {
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            f1 = executorService.submit(() -> first());
            f2 = executorService.submit(() -> second());
            f3 = executorService.submit(() -> first());
            executorService.shutdown();
        } while(f1.isDone()&&f2.isDone()&&f3.isDone());
    }


    public static void main(String[] args) throws Exception {

        new ThreeMethodExecution().runMyThreads();


        Thread.sleep(2000);
    }

}
