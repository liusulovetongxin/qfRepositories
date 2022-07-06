package com.qf.netty.http.controller;

import com.qf.netty.http.anno.RequestMapping;
import com.qf.netty.http.anno.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.http.controller
 * @Description:
 * @Date 2022/7/6 16:37
 */
@RestController
@RequestMapping("/test1")
public class TestController {


    @RequestMapping("/test1")
    public String test1(String name,String age){
        return "name: "+name+"age: "+age;
    }
    @RequestMapping("/test2")
    public Map test2(String id){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("uid", id);
        map.put("date", new Date());
        map.put("uuid", UUID.randomUUID().toString().replace("-", ""));
        return map;
    }
}
