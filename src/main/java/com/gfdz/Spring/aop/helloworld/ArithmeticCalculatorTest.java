package com.gfdz.Spring.aop.helloworld;

import org.junit.Test;

/**
 * Created by Administrator on 2015/9/29.
 */
public class ArithmeticCalculatorTest {
    @Test
    public void test() {
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy=  new ArithmeticCalulatorLoggingProxy(target).getLoggingProxy();
        int result=proxy.add(1,2);
        System.out.println(result);
        result=proxy.div(4, 2);
        System.out.println(result);
    }
}
