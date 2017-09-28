package com.se.oo.innerclass;

import com.se.util.Utils;

/**
 * Created by lty on 2017-9-20.
 */
public class CreateInnerInstance {

    public static void main(String[] args) {
        Out.In in = new Out().new In("测试");
        StaticOut.StaticIn staticIn = new StaticOut.StaticIn("测试");
    }
}

class Out {
    class In {
        public In(String msg) {
            Utils.out(msg);
        }
    }
}

class StaticOut {
    static class StaticIn {
        public StaticIn(String msg) {
            Utils.out(msg);
        }
    }
}
