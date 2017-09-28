package com.se.thread.practise;

import java.util.Arrays;

/**
 * Created by lty on 2017-9-19.
 */
public class Printter {


    private char[] chars = new char[26];
    private int[] bytes = new int[52];

    private boolean flag = true;

    private int wordIndex = 0;
    private int numberIndex = 0;

    public Printter() {
        char charA = 'A';
        char charZ = 'Z';
        int a = charA;
        int z = charZ;
        for (int i = a, j = 0; i <= z; i++, j++) {
            chars[j] = (char) i;
        }


        for (int i = 0; i < 52; i++) {
            bytes[i] = i + 1;
        }


    }


    public synchronized void printWord() {

        for (; wordIndex + 1 < chars.length; ) {
            if (!flag) {
                System.out.println(chars[wordIndex]);
                numberIndex += 1;
                flag = true;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public synchronized void printNumber() {
        System.out.println(":::::::::::::::"+bytes[numberIndex] + bytes[numberIndex + 1]);
        for (; numberIndex + 1 < bytes.length; ) {
            if (flag) {
                System.out.println(bytes[numberIndex] + bytes[numberIndex + 1]);
                numberIndex += 2;
                flag = false;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {


        //System.out.println(Arrays.toString(""));


    }

}
