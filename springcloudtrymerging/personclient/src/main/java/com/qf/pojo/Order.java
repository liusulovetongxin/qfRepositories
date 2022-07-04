package com.qf.pojo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/6/28 22:07
 */
@Data
@ToString
public class Order {

    private Long orderId;
    private String orderName;
    private BigDecimal price;
    private Long pid;
    private Date time;

}
