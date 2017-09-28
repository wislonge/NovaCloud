package com.se.collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by lty on 2017-9-21.
 */
public class ColloectionTest {

    public static void main(String[] args) {


        Collection c = new ArrayList<>();
        c.add("abc");

        c.add(6);
        c.add("321");

        System.out.println(""+c.contains(6));
        System.out.println(""+c);


        Collection h = new HashSet();
        h.add("123");
        h.add(10);
        h.add("321");

        System.out.println(""+c.containsAll(h));
//        c.removeAll(h);
//        System.out.println(""+c);

        c.retainAll(h);

        System.out.println(""+c);



    }

}
