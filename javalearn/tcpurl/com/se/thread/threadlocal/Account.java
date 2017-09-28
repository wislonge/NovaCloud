package com.se.thread.threadlocal;

/**
 * Created by lty on 2017-9-19.
 */
public class Account {

    private ThreadLocal<String> name = new ThreadLocal<>();
    private String id;

    public Account(String name, String id) {
        this.name.set(name);
        this.id = id;
        System.out.println("---" + this.name.get() + "---" + id);
    }

    public void setName(String src) {
        this.name.set(src);
    }

    public String getName() {
        return this.name.get();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
