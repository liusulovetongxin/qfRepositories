package com.qf.service.advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.advice
 * @Description:
 * @Date 2022/5/19 10:50
 */

public class MyTranAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.err.println("开启事务");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.err.println("提交事务");
    }
}
