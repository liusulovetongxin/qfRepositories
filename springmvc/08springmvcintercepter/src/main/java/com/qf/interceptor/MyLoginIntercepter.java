package com.qf.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.interceptor
 * @Description:
 * @Date 2022/5/23 20:19
 */

@Controller
public class MyLoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        System.err.println("MyLoginInterceptor中的方法preHandle 执行了=====>" + user);
        return user != null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("MyLoginIntercepter类中的postHandle方法执行了-->");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("MyLoginIntercepter类中的afterCompletion方法执行了-->");
    }
}
