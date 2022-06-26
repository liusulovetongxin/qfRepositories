package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf
 * @Description:
 * @Date 2022/6/23 19:07
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderStartApp {
    public static void main(String[] args){
        SpringApplication.run(OrderStartApp.class,args);
    }
}
