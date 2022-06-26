package com.qf.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.qf.pojo.Address;
import com.qf.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class OrderController {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private EurekaClient eurekaClient;

    @Autowired
    public void setEurekaClient(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @GetMapping("/info/{id}")
    public Order findById(@PathVariable Long id ){
        Order order = new Order();
        order.setId(id);
        order.setOrder("订单的名称===>"+id);
        order.setNum("订单的编号===>"+id);
        Address address = restTemplate.getForObject("http://ADDRESSPROVIDER04/address/info/" + id, Address.class);
        order.setAddress(address);
        return order;
    }
}
