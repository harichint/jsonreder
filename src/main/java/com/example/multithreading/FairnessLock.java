package com.example.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * If we want threads to run one after the other, then introduce sleep time which will put the threads
 * into blocki g state until the previous one is done,
 * actually if we can do this sequentially, we can probably use Synchronized?
 * answer is no, as synchronized cannot do blocking, Interruptablity, Fairness or ReadWrite
 *
 */
public class FairnessLock {
    private final Lock lock = new ReentrantLock(true);

    public void getResource() {

        try {
            lock.lock();
            System.out.println("lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(100);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println("lock released by: " + Thread.currentThread().getName());
        }
    }
    public static void main(String [] args) throws InterruptedException {
        FairnessLock fl = new FairnessLock();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                fl.getResource();
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");
        try {
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();
        } catch (Exception e) {

        }
    }


}
