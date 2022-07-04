package com.qf.service.impl;

import com.qf.mapper.OrderMapper;
import com.qf.pojo.Order;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/6/28 22:20
 */
@Service
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void addOrder(Order order) {
        order.setTime(new Date());
        orderMapper.addOrder(order);
    }

    @Override
    public Order findByOrderId(Long orderId) {
        return orderMapper.findByOrderId(orderId);
    }

    @Override
    public List<Order> findByPid(Long pid) {
        return orderMapper.findByPid(pid);
    }
}
