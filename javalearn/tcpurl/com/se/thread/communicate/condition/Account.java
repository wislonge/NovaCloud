package com.se.thread.communicate.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lty on 2017-9-18.
 * wait 导致当前线程等待，直到其他线程调用该同步监视器的notify方法来唤醒
 * notify  唤醒在此同步监视器等待的单个线程
 * notifyAll   唤醒在此同步监视器等待的所有线程
 */
public class Account {
    private String accountNo;
    private double balance;
    private boolean flag = false;

    //定义lock对象
    private final ReentrantLock lock = new ReentrantLock();
    //获得lock对象的condition
    private final Condition con = lock.newCondition();

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
            if (!flag) {
                con.await();
            } else {
                System.out.println(Thread.currentThread().getName() + "取款：" + drawAccount);
                balance -= drawAccount;
                System.out.println("账户余额为：" + balance);
                flag = false;
                con.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public void deposit(double depositAccount) {
        lock.lock();
        try {
            if (flag) {
                con.await();
            } else {
                System.out.println(Thread.currentThread().getName() + "存款：" + depositAccount);
                balance += depositAccount;
                System.out.println("账户余额为：" + balance);
                flag = true;
                con.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
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
