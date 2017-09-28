package com.se.collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by lty on 2017-9-21.
 */
public class IteratorTest {

    public static void main(String[] args) {
        Collection c = new ArrayList<>();
        c.add("abc");
        c.add("666");
        c.add("321");

        Iterator it = c.iterator();
        while (it.hasNext()) {
            String item = (String) it.next();
            {
                System.out.println("迭代元素：" + item);

            }


        }

    }
}
