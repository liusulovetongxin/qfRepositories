package com.qf.feign;

import com.qf.pojo.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.fegin
 * @Description:
 * @Date 2022/6/26 16:40
 */
//当使用@requestmapping的时候，需要使用factory，否则会报错
@FeignClient(value = "addressproviderhystrix10",fallbackFactory = AddressOpenFeignFallBackFactory.class)
//@FeignClient(value = "addressproviderhystrix10",fallback = AddressOpenFeignFallBack.class)
@RequestMapping("/address")
public interface AddressOpenFeign {

    @GetMapping("/info/{id}")
    Address findById(@PathVariable Long id);

    @GetMapping("/test2")
    String test2(@RequestParam("name") String name);
    @GetMapping("/test3")
    String test3(@RequestParam("name") String name,@RequestParam("age") int age);
    @PostMapping("/test4")
    Address test4(Address address);
}
