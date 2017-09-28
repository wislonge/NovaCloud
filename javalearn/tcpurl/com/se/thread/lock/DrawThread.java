package com.se.thread.lock;

/**
 * Created by lty on 2017-9-18.
 */
public class DrawThread extends Thread {


    private Account account;
    private double drawAccount;


    public DrawThread(String name, Account account, double drawAccount) {
        super(name);
        this.account = account;
        this.drawAccount = drawAccount;
    }

    @Override
    public void run() {
        account.draw(drawAccount);
    }


    public static void main(String[] args) {
        Account account = new Account("123456", 800);
        new DrawThread("甲", account, 500).start();
        new DrawThread("乙", account, 500).start();

    }
}
