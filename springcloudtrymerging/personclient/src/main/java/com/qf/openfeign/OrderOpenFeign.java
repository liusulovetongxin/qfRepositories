package com.qf.openfeign;

import com.qf.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.openfeign
 * @Description:
 * @Date 2022/6/28 22:56
 */
@FeignClient(value = "ORDERCLIENT")
public interface OrderOpenFeign {

    @GetMapping("/order/order/{id}")
    Order findById(@PathVariable Long id);

    @GetMapping("/order/orders/{pid}")
    List<Order> findByPid(@PathVariable Long pid);
}
