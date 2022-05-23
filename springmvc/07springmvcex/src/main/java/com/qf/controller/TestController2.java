package com.qf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/5/23 11:13
 */
@RestController
@RequestMapping("/test")
public class TestController2 {

    @RequestMapping("/test2")
    public String testEX1(String username){
        if (username == null){
            throw new RuntimeException("kong shuju");
        }
        return "fail";

    }
}
