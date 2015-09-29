package com.gfdz.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2015/9/29.
 */
public class BaseService<T>{
    @Autowired
    protected BaseRepository<T> repository;
    public void add(){
        System.out.println("add...");
        System.out.println(repository);


    }
}
