package com.gfdz.Spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/9/29.
 */
//把这个类说明为一个切面：需要把该类放入到IOC容器中、再声明为一个切面
    @Order(2)
@Aspect
@Component
public class LoggingAspect {
    /**
     * 定义一个方法，用于声明切入点表达式，一般的，该方法中再不需要添加其他代码
     * 使用 @Pointcut来声明切入点表达式
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式
     */
    @Pointcut("execution(* com.gfdz.Spring.aop.impl.*.*(..))")
    public void declareJoinPointExperssion(){}
    //前置通知：在目标方法开始之前执行
    @Before("declareJoinPointExperssion()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with" + args);
    }

    //后置通知：在目标方法开始之后（无论是否发生异常）执行
    @After("declareJoinPointExperssion())")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends ");
    }

    //返回通知：在目标方法正常结束之后执行，返回通知是可以访问到方法的返回值
    @AfterReturning(value = "declareJoinPointExperssion()", returning = "result")
    public void afterReturingMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);

    }

    //异常通知：在目标方法出现异常后执行，可以访问到异常对象；且可以指定在出现特定异常时再执行通知如：NullPointerException
    @AfterThrowing(value = "declareJoinPointExperssion())", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs with " + ex);

    }

    //环绕通知：需要携带ProceedingJoinPoint 类型的参数
    //环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法，且必须有返回值，返回值即目标方法的返回值
    @Around(value = "declareJoinPointExperssion())")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result=null;
        String methodName = pjd.getSignature().getName();
        try {
            result= pjd.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //执行目标方法
        System.out.println("The method " + methodName + " occurs ");
        return result;
    }
}
