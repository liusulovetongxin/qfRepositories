package com.qf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qf.pojo.Order;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/6/28 22:15
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return "success";
    }

    @GetMapping("/order/{orderId}")
    public Order findByOrderId(@PathVariable Long orderId){
        return orderService.findByOrderId(orderId);
    }


    @GetMapping("/orders/{pid}")
    @HystrixCommand(fallbackMethod = "findByPidHystrix")
    public List<Order> findByPid(@PathVariable Long pid){
        return orderService.findByPid(pid);
    }


    public List<Order> findByPidHystrix(@PathVariable Long pid){
        Order order = new Order();
        order.setPid(pid);
        order.setOrderName("此人没有订单，执行熔断，OrderClient服务器降级");
        List<Order> list = new ArrayList<>();
        list.add(order);
        return list;
    }
}
