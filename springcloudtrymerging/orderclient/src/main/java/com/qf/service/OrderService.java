package com.qf.service;

import com.qf.pojo.Order;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.service
 * @Description:
 * @Date 2022/6/28 22:17
 */

public interface OrderService {
    void addOrder(Order order);

    Order findByOrderId(Long orderId);

    List<Order> findByPid(Long pid);
}
