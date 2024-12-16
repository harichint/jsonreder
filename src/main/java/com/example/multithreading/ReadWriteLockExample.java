package com.example.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock example
 */
public class ReadWriteLockExample {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    int counter = 0;

    private void incrementCounter() {
        try {
            writeLock.lock();
            System.out.println("Write Lock Obtained by " + Thread.currentThread().getName());
            counter++;
            //Enable the below to see the read and write distribute nicely
            //without the below readwrite locks will read as long as write lock is not acquired
            // once write is completed, then the remaining reads are completed.

//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }

    }

    public int getCounter() {
        readLock.lock();
        try {
            return counter;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample counter = new ReadWriteLockExample();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() +
                            + counter.getCounter());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " : Incremented");
                    counter.incrementCounter();
                }
            }
        };
        Thread readThread1 = new Thread(readTask, "Read Thread");
        Thread readThread2 = new Thread(readTask, "Read Thread");
        Thread writeThreads = new Thread(writeTask, "Write Thread");
        writeThreads.start();
        readThread1.start();
        readThread2.start();
        writeThreads.join();
        readThread1.join();
        readThread2.join();
//        Thread.sleep(50);

    }
}
