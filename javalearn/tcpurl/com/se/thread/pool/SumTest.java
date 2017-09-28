package com.se.thread.pool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by lty on 2017-9-18.
 */
public class SumTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {


        int[] arr = new int[100];

        Random rand = new Random();

        int total = 0;

        for (int i = 0; i < arr.length; i++) {

            int tmp = rand.nextInt(20);
            total += (arr[i] = tmp);
        }
        System.out.println(total);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
        System.out.println(future.get());
        pool.shutdown();


    }

    static class CalTask extends RecursiveTask<Integer> {

        private final int MAX_SIZE = 20;
        private int arr[];
        private int start;
        private int end;

        public CalTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }


        @Override
        protected Integer compute() {

            int sum = 0;

            if (end - start < MAX_SIZE) {

                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {
                int middle = (start + end) / 2;
                CalTask left = new CalTask(arr, start, middle);
                CalTask right = new CalTask(arr, middle, end);

                left.fork();
                right.fork();

                return left.join() + right.join();

            }

        }
    }
}
