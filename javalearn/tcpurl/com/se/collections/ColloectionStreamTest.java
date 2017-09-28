package com.se.collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * Created by lty on 2017-9-21.
 */
public class ColloectionStreamTest {

    public static void main(String[] args) {
        Collection c = new ArrayList<>();
        c.add("abc");
        c.add("666");
        c.add("321");


        System.out.println(c.stream().filter(e -> ((String) e).contains("abc")).count());
        c.stream().forEach(System.out::println);


    }

}
