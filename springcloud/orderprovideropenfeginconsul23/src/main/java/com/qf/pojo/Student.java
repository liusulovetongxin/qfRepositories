package com.qf.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/7/1 21:36
 */
@ConfigurationProperties(prefix = "student") //对应consul配置中心上 student 前缀开始的配置信息
@Component
@Data
public class Student {
    private String name;
    private int age;
}
