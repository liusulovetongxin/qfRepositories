package com.qf.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/6/23 19:08
 */
@Data
@ToString
public class Order {
    private Long id;
    private String order;
    private String num;
    private Address address;
}
