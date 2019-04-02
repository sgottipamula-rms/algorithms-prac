package com.san.threading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable{

    Integer id;
    Lock[] forks;

    public Philosopher(Integer id, Lock[] forks) {
        this.id=id;
        this.forks = forks;
    }


    @Override
    public void run() {

        try {
            while(true) {

                Integer sleeptime = new Random().nextInt(10);

                //think
                Thread.sleep(sleeptime);

                //eat
                // mod 5 is because philosopher 4 uses f4 & f0 which is (4+1)%5
                Integer f1 = Math.min(id, (id + 1) % 5);
                Integer f2 = Math.max(id, (id + 1) % 5);

                synchronized (f1) {
                    synchronized (f2) {
                        System.out.println("philosopher:" + id + "eating with:" + f1 + ": and :" + f2);
                        Thread.sleep(sleeptime);
                    }
                }

                System.out.println("philosopher:" + id + "done with:" + f1 + ": and :" + f2);
            }
        } catch (InterruptedException e)
        {}

    }
}
