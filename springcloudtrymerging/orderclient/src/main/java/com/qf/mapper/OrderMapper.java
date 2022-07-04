package com.qf.mapper;

import com.qf.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/6/28 22:16
 */

public interface OrderMapper {
    void addOrder(Order order);

    Order findByOrderId(@Param("orderId") Long orderId);

    List<Order> findByPid(@Param("pid") Long pid);
}
