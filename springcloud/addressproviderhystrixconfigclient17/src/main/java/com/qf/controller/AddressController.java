package com.qf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qf.pojo.Address;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/6/23 19:00
 */
@RestController
@RequestMapping("/address")
@RefreshScope
public class AddressController {

    @Value("${server.port}")
    private int port;
    @Value("${women.zidingyi.name}")
    private String name;

    @GetMapping("/info/{id}")
    public Address findById(@PathVariable Long id){
        Address address = new Address();
        address.setId(id);
        address.setName("地址的名字===>"+id+"===>"+port);
        address.setPhone("地址的电话===>"+id+"===>"+port);
        return address;
    }
    @GetMapping("/test2")
    @HystrixCommand(fallbackMethod = "abc")
    public String test2(String name){
        if (new Random().nextBoolean()){
            int i = 1/0;
        }
        return "test2==>"+name;
    }


    @GetMapping("/test3")
    @HystrixCommand(fallbackMethod = "abc")
    public String test3(String name,int age){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "test3==>"+name+"age==>"+age;
    }

    @PostMapping("test4")
    public Address test4(@RequestBody Address address){
        address.setName("test4");
        return address;
    }

    public String abc(String name,int age){
        System.err.println("降级的方法触发了，收到的参数是name:" + name + " age:" + age);
        return "触发降级";
    }

    public String abc(String name){
        System.err.println("降级的方法触发了，收到的参数是name:" + name );
        return "触发降级";
    }

    @GetMapping("getname")
    public String getName(){
        return name;
    }
}
