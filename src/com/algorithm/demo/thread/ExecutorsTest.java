package com.algorithm.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        ex.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        Future future = ex.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
