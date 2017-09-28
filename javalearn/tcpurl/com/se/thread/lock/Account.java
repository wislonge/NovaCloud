package com.se.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lty on 2017-9-18.
 *
 */
public class Account {
    private String accountNo;
    private double balance;
    //5.0开始提供
    private final ReentrantLock lock = new ReentrantLock();

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    public void draw(double drawAccount) {
        lock.lock();
        try {
            if (balance > drawAccount) {
                System.out.println("取钱成功：" + drawAccount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= drawAccount;
                System.out.println("余额为：" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + "失败");
            }
        } finally {
            lock.unlock();
        }


    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
