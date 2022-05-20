package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/5/20 17:41
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test1")
    public void test1(){
        System.err.println("TestController类中的test1方法执行了-->");
    }
    @RequestMapping("/test2")
    public void test2(HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.err.println("TestController类中的test2方法执行了-->");
        request.getRequestDispatcher("test1").forward(request, response);
    }
    @RequestMapping("/test3")
    public void test3(HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.err.println("TestController类中的test3方法执行了-->");
        request.getRequestDispatcher("/test/test2").forward(request, response);
    }

    @RequestMapping("/test4")
    public String test4(HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.err.println("TestController类中的test4方法执行了-->");
//        return "forward:test3";
        return "forward:/test/test3";
    }
    @RequestMapping("/test5")
    public String test5(HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.err.println("TestController类中的test5方法执行了-->");
//        return "forward:test3";
        return "/test/test4";
    }
}
