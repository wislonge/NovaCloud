package com.se.thread.communicate.blocking;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2017-9-18.
 */
public class Producer extends Thread {

    private BlockingQueue<String> bg;

    public Producer(BlockingQueue<String> bq) {
        this.bg = bq;
    }

    @Override
    public void run() {

        String[] strArr = {"A", "B", "C"};
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + "-->准备生产");
            try {
                Thread.sleep(200);
                bg.put(strArr[i % 3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "-->生产完成" + bg);

        }
    }
}
