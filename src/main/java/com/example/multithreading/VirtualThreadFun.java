package com.example.multithreading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class under Java 21 will not produce any outofmemory.
 */
public class VirtualThreadFun {
    private static final Lock lock = new ReentrantLock();
    public static void main( String[] args ){
        final int numberOfThreads = 1_000_000;
        try {
            for (int i = 0; i < numberOfThreads; i++) {
                Thread virtualThread = Thread.ofVirtual().unstarted(new BlockedThread(i));
                virtualThread.start();
                String str = String.format("Java 21 virtual thread number %s is running.", i);
                System.out.println(str);
            }
            System.out.println("All threads under  have run under Java 21.");
        } catch (OutOfMemoryError e) {
            // Handle the OutOfMemoryError
            try {
                String str = "Java 11 - Caught OutOfMemoryError: " + e.getMessage();
                // Create a FileWriter with append mode (true)
                FileWriter fileWriter = new FileWriter("error.log", true);
                // Wrap the FileWriter with a BufferedWriter for efficient writing
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                // Append the line to the file
                bufferedWriter.write(str);
                // Add a new line after the appended text
                bufferedWriter.newLine();

                // Close the resources
                bufferedWriter.close();

                fileWriter.close();

                System.err.println(str);

                System.exit(1);

            } catch (IOException err) {
                // Handle exceptions
                err.printStackTrace();
            }
        }
    }

    static class BlockedThread implements Runnable {
        private int count = 0;
        public BlockedThread(int count){
            this.count = count;
        }
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("Thread output for " + this.count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Handle InterruptedException if needed
            } finally {
                lock.unlock(); // This line will never be reached
            }
        }
    }
}
