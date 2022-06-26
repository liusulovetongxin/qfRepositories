package com.qf.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/6/23 18:59
 */
@Data
@ToString
public class Address {
    private Long id;
    private String name;
    private String phone;
}
