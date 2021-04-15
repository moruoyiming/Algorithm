package com.algorithm.demo.thread;

import com.sun.tools.javac.util.Abort;

import java.util.concurrent.*;

public class ExecutorsTest {

    /**
     * corePoolSize：线程池的核心线程数；
     * <p>
     * maximumPoolSize：线程池的最大线程数；
     * <p>
     * keepAliveTime：线程池空闲时线程的存活时长；
     * <p>
     * unit：线程存活时长大单位，结合上个参数使用；
     * <p>
     * workQueue：存放任务的队列，使用的是阻塞队列；
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService ex = new ThreadPoolExecutor(3, 5, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                super.rejectedExecution(r, e);
                System.out.println("rejected Execution");
            }
        }
        );


        for (int i = 0; i < 20; i++) {
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Runnable execute");
                }
            });
        }

        Future future = ex.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable submit");
            }
        });
//        shutdown()：不会立即终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务
        ex.shutdown();
//        shutdownNow()：立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务
        ex.shutdownNow();

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(12);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(12);

    }

}
