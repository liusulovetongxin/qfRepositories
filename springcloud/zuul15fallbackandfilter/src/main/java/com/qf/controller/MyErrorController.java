package com.qf.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.controller
 * @Description:
 * @Date 2022/6/27 20:03
 */
@RestController
public class MyErrorController implements ErrorController {


    @RequestMapping("/error")
    public String error(){
        return "我的错误信息";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
