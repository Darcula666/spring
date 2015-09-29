package com.gfdz.Spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by Administrator on 2015/9/29.
 * 动态代理
 */
public class ArithmeticCalulatorLoggingProxy {
    //被代理对象
    private ArithmeticCalculator target;

    public ArithmeticCalulatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;
        //代理对象由哪个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中的哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        //当调用代理对象其中的方法是，执行的代码
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy:正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
             * @param method：正在被调用的方法
             * @param args：调用方法时，传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String methodName = method.getName();
                //日志
                System.out.println("The method" + methodName + "begins with" + Arrays.asList(args));
                Object res = method.invoke(target, args);
                //日志
                System.out.println("The method" + methodName + "ends with" +res);
                return res;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);
        return proxy;
    }
}
