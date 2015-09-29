package com.gfdz.Spring.aop.impl;

import com.gfdz.Spring.aop.helloworld.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/9/29.
 */
public class ArithmeticCalculatorTest {
    @Test
    public void test() {
        //1.创建spring的IOC容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
        //2.从IOC日期中获取bean的实力
        ArithmeticCalculator arithmeticCalculator=ctx.getBean(ArithmeticCalculator.class);
        //3.使用bean
        int resul=arithmeticCalculator.add(3,6);
        System.out.println("result:"+resul);
         resul=arithmeticCalculator.div(12,3);
        System.out.println("result:"+resul);
    }
}
