package com.algorithm.demo.thread;

public class JoinTest {
    static Thread thread1, thread2;

    public static void main(String[] args) {
        thread1 = new Thread() {
            @Override
            public void run() {
                // 打印线程开始执行信息。
                System.out.println("thread1 start");
                try {
                    // 休眠一分钟，模拟耗时任务。
                    Thread.sleep(1000);
                    thread2.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 end");
            }
        };

        thread2 = new Thread() {
            @Override
            public void run() {
                // 开始线程主体之前先获取锁对象'lock2'。
                // 打印线程开始执行信息。
                System.out.println("thread2 start");
                try {
                    // 休眠一分钟，模拟耗时任务。
                    Thread.sleep(1000);
                    thread1.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 end");
            }
        };

        // 启动线程
        thread1.start();
        thread2.start();

    }


}
