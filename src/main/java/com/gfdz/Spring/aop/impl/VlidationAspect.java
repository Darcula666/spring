package com.gfdz.Spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Administrator on 2015/9/29.
 * 可以使用@Order 注解切面的优先级，值越小优先级越高
 */
@Order(1)
@Component
@Aspect
public class VlidationAspect {
    @Before("com.gfdz.Spring.aop.impl.LoggingAspect.declareJoinPointExperssion()")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate:"+ Arrays.asList(joinPoint.getArgs()));

    }
}
