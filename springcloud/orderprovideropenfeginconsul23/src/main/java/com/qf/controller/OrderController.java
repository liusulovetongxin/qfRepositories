package com.qf.controller;

import com.qf.feign.AddressOpenFeign;
import com.qf.pojo.Address;
import com.qf.pojo.Order;
import com.qf.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/6/23 19:08
 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Value("${suibian.ceshi.name}")
    private String name;

    private Student student;

    @Autowired
    public void setStu(Student student) {
        this.student = student;
    }

    private AddressOpenFeign addressOpenFeign;

    @Autowired
    public void setAddressOpenFeign(AddressOpenFeign addressOpenFeign) {
        this.addressOpenFeign = addressOpenFeign;
    }

    @GetMapping("/info/{id}")
    public Order findById(@PathVariable Long id ){
        Order order = new Order();
        order.setId(id);
        order.setOrder("订单的名称===>"+id);
        order.setNum("订单的编号===>"+id);
        Address address = addressOpenFeign.findById(id);
        order.setAddress(address);
        return order;
    }

    @GetMapping("/test2")
    public String test2(String name){
        return addressOpenFeign.test2(name);
    }
    @GetMapping("/test3")
    public String test3(String name,int age){
        return addressOpenFeign.test3(name,age);
    }
    @GetMapping("/test4/{id}")
    public Address test4(@PathVariable Long id){
        Address address = new Address();
        address.setId(id);
        return addressOpenFeign.test4(address);
    }


    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/stu")
    public Student getStudent() {
        return student;
    }
}
