package com.se.thread.communicate.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2017-9-18.
 */
public class BlockingQueuTest {


    public static void main(String[] args) {
        BlockingQueue<String>  bg =new ArrayBlockingQueue<String>(1);

        new Producer(bg).start();
        new Producer(bg).start();
        new Producer(bg).start();

        new Consumer(bg).start();

    }
}
