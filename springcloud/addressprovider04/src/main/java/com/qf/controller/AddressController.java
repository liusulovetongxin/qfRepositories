package com.qf.controller;

import com.qf.pojo.Address;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
public class AddressController {

    @Value("${server.port}")
    private int port;
    @GetMapping("/info/{id}")
    public Address findById(@PathVariable Long id){
        Address address = new Address();
        address.setId(id);
        address.setName("地址的名字===>"+id+"===>"+port);
        address.setPhone("地址的电话===>"+id+"===>"+port);
        return address;
    }
    @GetMapping("/test2")
    public String test2(String name){
        return "test2==>"+name;
    }
    @GetMapping("/test3")
    public String test3(String name,int age){
        return "test3==>"+name+"age==>"+age;
    }
    @PostMapping("test4")
    public Address test4(@RequestBody Address address){
        address.setName("test4");
        return address;
    }
}
