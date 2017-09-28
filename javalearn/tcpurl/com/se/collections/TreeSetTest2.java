package com.se.collections;


import java.util.TreeSet;

/**
 * Created by lty on 2017-9-21.
 */
class TreeSetTest2 {


    public static void main(String[] args) {

        TreeSet set = new TreeSet();
        set.add(new R(5));
        set.add(new R(-3));
        set.add(new R(10));
        set.add(new R(59));
        set.add(new R(2));

        System.out.println(set);



    }

}


class R implements Comparable {

    int count;

    public R(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Object o) {

        R r = (R) o;
        return count > r.count ? 1 : count < r.count ? -1 : 0;
    }

    @Override
    public String toString() {
        return "{s count=" + count + "}";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj != null && obj.getClass() == R.class) {
            R r = (R) obj;
            return r.count == this.count;
        }
        return false;
    }
}