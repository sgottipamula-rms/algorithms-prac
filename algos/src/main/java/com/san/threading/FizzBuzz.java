package com.san.threading;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzz {


    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    Lock lock3 = new ReentrantLock();
    Lock lock4 = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzbuzz();


        Thread.sleep(10000);
    }

    public void fizzbuzz() {

        Queue<Integer> integerQueue = new LinkedList<>();

        new Thread(new PopulatorThread(integerQueue)).start();
        new Thread(new FizzBuzzThread(integerQueue)).start();
        new Thread(new FizzThread(integerQueue)).start();
        new Thread(new BuzzThread(integerQueue)).start();
        new Thread(new NumThread(integerQueue)).start();
    }


    class FizzBuzzThread implements Runnable {

        Queue<Integer> integerQueue;

        public FizzBuzzThread(Queue<Integer> integerQueue) {
            this.integerQueue = integerQueue;
        }

        @Override
        public void run() {

            while(true) {

                lock1.lock();lock1.unlock();

                lock2.lock();
                if( ! integerQueue.isEmpty()) {
                    int num = integerQueue.peek();
                    if (num % 3 == 0 && num % 5 == 0) {
                        System.out.println("FizzBuzz");
                        integerQueue.remove();
                    }
                }
                lock2.unlock();
            }

        }
    }

    class FizzThread implements Runnable {

        Queue<Integer> integerQueue;

        public FizzThread(Queue<Integer> integerQueue) {
            this.integerQueue = integerQueue;
        }

        @Override
        public void run() {

            while(true) {
                lock2.lock();lock2.unlock();
                lock3.lock();
                if( ! integerQueue.isEmpty()) {
                    int num = integerQueue.peek();
                    if (num % 3 == 0) {
                        System.out.println("Fizz");
                        integerQueue.remove();
                    }
                }
                lock3.unlock();
            }

        }
    }

    class BuzzThread implements Runnable {

        Queue<Integer> integerQueue;

        public BuzzThread(Queue<Integer> integerQueue) {
            this.integerQueue = integerQueue;
        }

        @Override
        public void run() {

            while(true) {
                lock3.lock();lock3.unlock();
                lock4.lock();
                if( ! integerQueue.isEmpty()) {
                    int num = integerQueue.peek();
                    if (num % 5 == 0) {
                        System.out.println("Buzz");
                        integerQueue.remove();
                    }
                }
                lock4.unlock();
            }
        }
    }

    class NumThread implements Runnable {

        Queue<Integer> integerQueue;

        public NumThread(Queue<Integer> integerQueue) {
            this.integerQueue = integerQueue;
        }

        @Override
        public void run() {

            while(true) {
                lock4.lock();
                if( ! integerQueue.isEmpty())
                    System.out.println(integerQueue.remove());
                lock4.unlock();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class PopulatorThread implements Runnable {

        Queue<Integer> integerQueue;

        public PopulatorThread(Queue<Integer> integerQueue) {
            this.integerQueue = integerQueue;
        }

        @Override
        public void run() {

            lock1.lock();
            for(int i=0;i<100;i++)
                integerQueue.add(i);
            lock1.unlock();
        }
    }


}
