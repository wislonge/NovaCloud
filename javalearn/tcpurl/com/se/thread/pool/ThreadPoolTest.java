package com.se.thread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lty on 2017-9-18.
 */
public class ThreadPoolTest {


    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(6);
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->的i值为" + i);
                }
            }
        };
        pool.submit(target);
        pool.submit(target);

        pool.shutdown();
    }


}
