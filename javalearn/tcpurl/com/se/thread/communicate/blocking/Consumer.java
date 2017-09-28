package com.se.thread.communicate.blocking;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2017-9-18.
 */
public class Consumer extends Thread {
    private BlockingQueue<String> bg;

    public Consumer(BlockingQueue<String> bq) {
        this.bg = bq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(getName() + "-->准备消费");
                bg.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "-->消费完成" + bg);

        }
    }
}