package com.se.thread.threadlocal;

/**
 * Created by lty on 2017-9-19.
 */
public class MyTest extends Thread {

    private Account account;

    public MyTest(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                account.setName(getName());
                account.setId(getName() + "123456");
            }
            System.out.println("---" + account.getName() + "--  i --->" + i + ",id--" + account.getId());
        }

    }
}
