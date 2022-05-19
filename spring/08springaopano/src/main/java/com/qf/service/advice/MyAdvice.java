package com.qf.service.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.advice
 * @Description:
 * @Date 2022/5/19 14:40
 */

@Aspect
@Component
public class MyAdvice {

    @Pointcut("execution(* com..impl.*Impl.*(..))")
    public void pc(){
    }


    @Before(value = "pc()")
    public void before(JoinPoint joinPoint){
        System.err.println("前置通知开启事务");
    }

    @AfterReturning(value = "pc()",returning = "result")
    public void after(JoinPoint joinPoint,Object result){
        System.err.println(joinPoint.getSignature());
        System.err.println("后置通知提交事务===>"+result);
    }


    @AfterThrowing(value = "pc()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        e.printStackTrace();
        System.err.println("异常通知完成");
    }

    @Around("pc()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.err.println("环绕通知前边部分");
        System.err.println("环绕通知开启事务");
        Object result = joinPoint.proceed();
        System.err.println("环绕通知后半部分");
        System.err.println("环绕通知提交事务");
    }
}
