package com.example.multithreading;

import java.util.Currency;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Cyclic Barrier is synchronization mechanism to make  threads wait for other threads to complete.
 * this is alternative to CountDownLach. CycclicBarrier has more advantage like
 * resetting, reuse of Barrier.
 * Barrier Await block calling thread until all parties have reached Barrier point.
 * so this program will print the barrier point by the last thread which reaches the barrier point.
 */
public class CyclicBarrierExample {

    public static void main(String [] args) {
        int subsystemsCount = 4;
        Runnable task  = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "All Sub systems are up and running. System startup complete.");
            }
        };
        CyclicBarrier barrier = new CyclicBarrier(subsystemsCount, task);
        Thread webServerThread = new Thread(new SubSystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new SubSystem("Database", 3000, barrier));
        Thread cacheThread = new Thread(new SubSystem("Cache", 4000, barrier));
        Thread messagingServiceThread = new Thread(new SubSystem("Messaging Service", 4500, barrier));
        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();
    }
}

class SubSystem implements Runnable {
    private String name;
    private int initializationTime;
    private CyclicBarrier barrier;

    public SubSystem(String webServer, int i, CyclicBarrier barrier) {
        super();
        this.name = name;
        this.initializationTime = i;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(name + " Initialization Started " );
        try {
            Thread.sleep(initializationTime);
            System.out.println(name + " Initialization Completed");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}