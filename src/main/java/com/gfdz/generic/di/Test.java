package com.gfdz.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/9/29.
 */
public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService= (UserService) ctx.getBean("userService");
        userService.add();

    }
}
