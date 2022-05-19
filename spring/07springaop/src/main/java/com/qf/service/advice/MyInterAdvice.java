package com.qf.service.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Random;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.advice
 * @Description:
 * @Date 2022/5/19 11:07
 */

public class MyInterAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.err.println("判断是否符合条件");
        System.err.println("如果条件成立，则继续执行");
        System.err.println("开启事务");
        if (new Random().nextBoolean()){
            return null;
        }
        Object result = invocation.proceed();
        System.err.println("判断返回的逻辑");
        System.err.println("返回也没有问题");
        System.err.println("提交事务");
        return result;
    }
}
