package com.san.threading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    //philosophers are threads
    //forks are resources that need to be given

    Philosopher[] philosophers;
    Lock[] forks;

    public DiningPhilosophers() {
        philosophers = new Philosopher[5];
        forks = new Lock[5];
    }

    public void go() {

        for(int i=0;i<5;i++)
            forks[i] = new ReentrantLock();

        for(int i=0;i<5;i++) {
            philosophers[i] = new Philosopher(i,forks);
        }

        for(int i=0;i<5;i++) {
            new Thread(philosophers[i]).start();
        }
    }


    public static void main(String[] args) throws Exception{

        DiningPhilosophers diningPhilosophers  =new DiningPhilosophers();
        diningPhilosophers.go();

        Thread.sleep(20000);
    }
}
