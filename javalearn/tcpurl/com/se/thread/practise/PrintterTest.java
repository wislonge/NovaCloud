package com.se.thread.practise;

/**
 * Created by Administrator on 2017-9-19.
 */
public class PrintterTest {


    static class NumberThread extends Thread {

        private Printter printter;

        public NumberThread(Printter printter) {
            this.printter = printter;
        }

        @Override
        public void run() {
            printter.printNumber();
        }
    }

    static class WordThread extends Thread {

        private Printter printter;

        public WordThread(Printter printter) {
            this.printter = printter;
        }

        @Override
        public void run() {
            printter.printWord();
        }
    }

    public static void main(String[] args) {


        //System.out.println(Arrays.toString(""));
        Printter printter=new Printter();
        new NumberThread(printter).start();
        new WordThread(printter).start();

    }
}
