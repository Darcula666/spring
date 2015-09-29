package com.gfdz.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/9/28.
 */
public class HelloworldTest {
    @Test
    public void test(){
        //1.创建IOC容器
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-config.xml");
        //2.从IOC容器中获取bean实例
        Helloworld helloworld= (Helloworld) ctx.getBean("helloworld");
        //3.调用hello方法
        helloworld.hello();
    }
}
