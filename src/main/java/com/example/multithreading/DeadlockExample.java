package com.example.multithreading;

import lombok.Synchronized;

/**
 * DeadLock with Pen and paper example. have to explicitly terminate to come out of this deadlock.
 * in order to solve this particular deadlock which is kind of Circular wait.
 * make sure to uncomment the task1
 */
public class DeadlockExample {
    public static void main(String [] args) {
        Pen p = new Pen();
        Paper pa = new Paper();
        Thread t1 = new Thread(new Task1(pa, p), "Thread 1");
        Thread t2 = new Thread(new Task2(pa, p), "Thread 2");
        t1.start();
        t2.start();
    }
}
    class Pen {
        public synchronized void writeWithPenAndPaper (Paper paper) {
            System.out.println(Thread.currentThread().getName() + " - Pen is using Paper "+this+"and writing ");
            paper.finishiWriting();
        }
        public synchronized void finishiWriting() {
            System.out.println(Thread.currentThread().getName() + " - Pen finished writing "+this);
        }
    }
    class Paper {

        public synchronized void  writeWithPenAndPaper (Pen pen) {
            System.out.println(Thread.currentThread().getName() + " - Paper is using Pen "+this+"and writing ");

            pen.finishiWriting();
        }
        public  synchronized void finishiWriting() {
            System.out.println(Thread.currentThread().getName() + " - Paper finished writing "+this);
        }
    }

    class Task1 implements Runnable {
        private  Pen pen;
        private  Paper paper;
        public Task1(Paper paper, Pen pen) {
            this.paper = paper;
            this.pen = pen;
        }
        @Override
        public void run() {
//            synchronized (paper) {
                pen.writeWithPenAndPaper(paper);
//            }
        }
    }
    class Task2 implements Runnable {
        private  Pen pen;
        private  Paper paper;
        public Task2(Paper paper, Pen pen) {
            this.paper = paper;
            this.pen = pen;
        }
        @Override
        public void run() {
            paper.writeWithPenAndPaper(pen);
        }
    }

