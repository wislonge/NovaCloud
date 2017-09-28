package com.se.thread.threadlocal;

/**
 * Created by lty on 2017-9-19.
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        Account account = new Account("初始值","000000");

        new MyTest("甲", account).start();
        new MyTest("乙", account).start();

    }


}
