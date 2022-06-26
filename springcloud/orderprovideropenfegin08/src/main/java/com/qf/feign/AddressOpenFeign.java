package com.qf.feign;

import com.qf.pojo.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.fegin
 * @Description:
 * @Date 2022/6/26 16:40
 */
@FeignClient("ADDRESSPROVIDER04")
public interface AddressOpenFeign {

    @GetMapping("/address/info/{id}")
    Address findById(@PathVariable Long id);

    @GetMapping("/address/test2")
    String test2(@RequestParam("name") String name);
    @GetMapping("/address/test3")
    String test3(@RequestParam("name") String name,@RequestParam("age") int age);
    @PostMapping("/address/test4")
    Address test4(Address address);
}
