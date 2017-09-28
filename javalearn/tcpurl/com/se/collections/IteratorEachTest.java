package com.se.collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by lty on 2017-9-21.
 */
public class IteratorEachTest {

    public static void main(String[] args) {
        Collection c = new ArrayList<>();
        c.add("abc");
        c.add("666");
        c.add("321");

        Iterator it = c.iterator();

        it.forEachRemaining(o -> System.out.println("迭代元素：" + o));


    }
}
