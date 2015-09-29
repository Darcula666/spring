package com.gfdz.Spring.aop.helloworld;

/**
 * Created by Administrator on 2015/9/29.
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        int result=i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result=i-j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result=i*j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result=i/j;
        return result;
    }
}
