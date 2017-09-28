package com.se.collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * Created by lty on 2017-9-21.
 */
public class ColloectionEachTest {

    public static void main(String[] args) {
        Collection c = new ArrayList<>();
        c.add("abc");
        c.add(6);
        c.add("321");


        //c.forEach(e -> System.out.println("迭代元素：" + e));

        c.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("迭代元素：" + o);
            }
        });


    }

}
