package com.san.threading;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzz {

        public void runFizzBuzzThreads() {

            final Queue<Integer> fbQueue = new LinkedList<>();
            Queue<Integer> fQueue = new LinkedList<>();
            Queue<Integer> bQueue = new LinkedList<>();
            Queue<Integer> lQueue = new LinkedList<>();
            ExecutorService executorService = Executors.newFixedThreadPool(4);


            //populator
            executorService.submit(() -> {
                for(int i=0;i<100;i++) {
                    synchronized (fbQueue) {
                        fbQueue.add(i);
                        fbQueue.notify();
                    }
                }
            });

            //fizzbuzz
            executorService.submit(() -> {
                while (!fbQueue.isEmpty()) {
                    int num = fbQueue.remove();
                    if (num % 15 == 0) {
                        System.out.println(num + ":FIZZBUZZ");
                    } else {
                        fQueue.add(num);
                        bQueue.add(num);
                    }
                }
            });

            //FIZZ
            executorService.submit(() -> {
                while (!fQueue.isEmpty()) {
                    int num = fQueue.remove();
                    if (num % 3 == 0) {
                        System.out.println(num + ":FIZZ");
                    } else {
                        lQueue.add(num);
                    }
                }
            });

            //FIZZ
            executorService.submit(() -> {
                while (!bQueue.isEmpty()) {
                    int num = bQueue.remove();
                    if (num % 5 == 0) {
                        System.out.println(num + ":BUZZ");
                    } else {
                        lQueue.add(num);
                    }
                }
            });

            //LAST
            executorService.submit(() -> {
                while (!lQueue.isEmpty()) {
                    int num = lQueue.remove();
                    System.out.println(num + ":NUM");
                }
            });

            executorService.shutdown();
        }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.runFizzBuzzThreads();
    }

}
