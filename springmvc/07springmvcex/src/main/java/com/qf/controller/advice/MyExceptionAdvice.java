package com.qf.controller.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.controller.advice
 * @Description:
 * @Date 2022/5/23 11:16
 */
@RestControllerAdvice
public class MyExceptionAdvice {

    @ExceptionHandler(NullPointerException.class)
    public String processNull(NullPointerException e){
        e.printStackTrace();
        return "网络异常，请检查网络";
    }

    @ExceptionHandler(Exception.class)
    public String process(Exception e){
        e.printStackTrace();
        return "未知异常 ";
    }
}
