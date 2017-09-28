package com.se.thread.synchronize;

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
        synchronized (account) {

            if (account.getBalance() > drawAccount) {
                System.out.println("取钱成功：" + drawAccount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance() - drawAccount);
                System.out.println("余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + "失败");
            }
        }
    }


    public static void main(String[] args) {
        Account account = new Account("123456", 800);
        new DrawThread("甲", account, 500).start();
        new DrawThread("乙", account, 500).start();

    }
}
