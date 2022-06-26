package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.SysLogininfor;
import com.qf.service.LoginInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootssm
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/6/14 11:46
 */
@RestController
public class TestController {
    private LoginInforService loginInforService;

    @Autowired
    public void setLoginInforService(LoginInforService loginInforService) {
        this.loginInforService = loginInforService;
    }

    @GetMapping("/test1")
    public PageInfo<SysLogininfor> test1(@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        PageInfo<SysLogininfor> pageInfo = loginInforService.findAll(pageNum, pageSize);
        return pageInfo;
    }
    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }
    @GetMapping("/test3")
    public String test3(){
        return "test3";
    }
}
