package com.qf.controller;

import com.qf.pojo.Address;
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
    @GetMapping("/info/{id}")
    public Address findById(@PathVariable Long id){
        Address address = new Address();
        address.setId(id);
        address.setName("地址的名字===>"+id);
        address.setPhone("地址的电话===>"+id);
        return address;
    }
}
