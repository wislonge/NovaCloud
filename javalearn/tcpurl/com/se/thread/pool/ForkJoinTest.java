package com.se.thread.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by lty on 2017-9-18.
 */
public class ForkJoinTest {


    public static void main(String[] args) throws InterruptedException {

        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new PrintTask(0,300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();


    }

    static class PrintTask extends RecursiveAction {

        private final int MAX_SIZE = 50;
        private int start;
        private int end;

        public PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            if (end - start < MAX_SIZE) {

                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + "--》 i  值" + i);
                }
            } else {
                int middle = (start + end) / 2;
                PrintTask left = new PrintTask(start, middle);
                PrintTask right = new PrintTask(middle, end);

                left.fork();
                right.fork();

            }

        }
    }
}
