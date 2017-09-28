package com.se.collections;

import java.util.TreeSet;

/**
 * Created by lty on 2017-9-21.
 */
public class TreeSetTest {


    public static void main(String[] args) {

        TreeSet set =new TreeSet();
        Z z = new Z(6);
        set.add(z);
        System.out.println(set.add(z));
        System.out.println(set);

    }

}


class Z implements Comparable {

    int age;

    public Z(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}