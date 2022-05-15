package com.qf.test;

import com.github.pagehelper.PageHelper;
import com.qf.Utils.MybatisUtils;
import com.qf.mapper.OrderMapper;
import com.qf.pojo.Order;
import org.junit.Test;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo1
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/15 21:05
 */

public class TestOrderMapper {
    @Test
    public void testFindAll(){
        OrderMapper orderMapper = MybatisUtils.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.FindAll();
        if (orders != null) {
            for (Order order : orders) {
                System.out.println(order.toString());
            }
        }
    }
    @Test
    public void testFindAllOrderPageHelper(){
        OrderMapper orderMapper = MybatisUtils.getMapper(OrderMapper.class);
        PageHelper.startPage(1,2);
        List<Order> list = orderMapper.findAllOrderPageHelper();
        for (Order order : list) {

        }
    }
}
