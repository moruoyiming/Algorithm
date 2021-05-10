package com.algorithm.demo.thread;

/**
 * 三个线程 ，顺序打印ABC、ABC
 * lock实现方案
 */
public class ABCABC2 {

    private volatile int status = 0;

    private class MyRunnable implements Runnable {
        private int times = 10;
        private Object lock;
        private int thisStatus;
        private int nextStatus;
        private char ch;

        public MyRunnable(Object lock, int thisStatus, int nextStatus, char ch) {
            this.lock = lock;
            this.thisStatus = thisStatus;
            this.nextStatus = nextStatus;
            this.ch = ch;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < times; i++) {
                    while (status != thisStatus) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(ch);
                    status = nextStatus;
                    lock.notifyAll();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ABCABC2 abcabc2 = new ABCABC2();
        abcabc2.text();
    }

    public void text() throws InterruptedException {
        Object lock = new Object();
        MyRunnable myRunnableA = new MyRunnable(lock, 0, 1, 'A');
        MyRunnable myRunnableB = new MyRunnable(lock, 1, 2, 'B');
        MyRunnable myRunnableC = new MyRunnable(lock, 2, 0, 'C');
        new Thread(myRunnableA).start();
        Thread.sleep(100);
        new Thread(myRunnableB).start();
        Thread.sleep(100);
        new Thread(myRunnableC).start();
    }

}
