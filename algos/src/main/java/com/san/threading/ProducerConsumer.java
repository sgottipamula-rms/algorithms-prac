package com.san.threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    int MAX=10;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    private final Queue<Integer> queue = new LinkedList<>();


    public void produce(int i) {
        lock.lock();
        try {

            while(queue.size()==MAX)
                condition.await();

            queue.offer(i);
            System.out.println("Produced"+i);
            condition.signal();
        } catch (InterruptedException e){}
        finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {

            while(queue.size()==0)
                condition.await();

            System.out.println("consumed" + queue.poll());
            condition.signal();

        } catch (InterruptedException e){}
        finally {
            lock.unlock();
        }
    }

    public void runProducerConsumer() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                int counter=0;
                while(true) {
                    produce(counter++);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    consume();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws Exception{
        ProducerConsumer producerConsumer = new ProducerConsumer();

        producerConsumer.runProducerConsumer();

        Thread.sleep(10000);
    }
}
