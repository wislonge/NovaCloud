package com.se.thread.communicate.condition;

public class DrawTest {

    static class DrawThread extends Thread {


        private Account account;
        private double drawAccount;


        public DrawThread(String name, Account account, double drawAccount) {
            super(name);
            this.account = account;
            this.drawAccount = drawAccount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                account.draw(drawAccount);
            }
        }


    }


    static  class DepositThread extends Thread {


        private Account account;
        private double drawAccount;


        public DepositThread(String name, Account account, double drawAccount) {
            super(name);
            this.account = account;
            this.drawAccount = drawAccount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                account.deposit(drawAccount);
            }
        }

    }

    public static void main(String[] args) {
        Account account = new Account("123456", 0);
        new DrawThread("取款者：", account, 500).start();
        new DepositThread("甲", account, 500).start();
        new DepositThread("乙", account, 500).start();
        new DepositThread("丙", account, 500).start();

    }
}