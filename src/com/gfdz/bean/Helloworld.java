package com.gfdz.bean;



/**
 * Created by Administrator on 2015/9/28.
 */
public class Helloworld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Helloworld() {
    }
    public void hello(){
        System.out.println("hello"+name);
    }
}
