package com.qf.mapper;

import com.qf.pojo.Order;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo1
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/15 20:44
 */

public interface OrderMapper {
    public List<Order> FindAll();
    public List<Order> findAllOrderPageHelper();
}
