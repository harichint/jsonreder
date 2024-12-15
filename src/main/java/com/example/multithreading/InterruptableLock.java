package com.example.multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * InterruptableLock will allow other thread to interrupt .
 * the output of this program is:
 * Thread 1 obtained Lock
 * Thread 2 interrupted Thread 1 // i.e. t1 allowed t2 to interrupt actually after the 1ms sleeptime
 * Thread 1 interrupted
 * Thread 1 release lock
 */
public class InterruptableLock {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String [] args) {
        Thread t1 = new Thread(() -> {

            try {
                lock.lockInterruptibly();
                System.out.println("Thread 1 obtained Lock");
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("Thread 1 interrupted");
            } finally {
                if (lock.isHeldByCurrentThread())
                    lock.unlock();
                System.out.println("Thread 1 release lock");
            }
        });

        Thread t2 = new Thread(() ->{
            try {
                Thread.sleep(1000);
                t1.interrupt();
                System.out.println("Thread 2 interrupted Thread 1");
            } catch (Exception e) {
                System.out.println("Thread 2 interrupted");
            }
        });
        t1.start();
        t2.start();
    }
}
