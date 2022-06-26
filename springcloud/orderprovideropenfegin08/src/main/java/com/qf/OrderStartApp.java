package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf
 * @Description:
 * @Date 2022/6/23 19:07
 */
@SpringBootApplication
@EnableFeignClients
public class OrderStartApp {
    public static void main(String[] args){
        SpringApplication.run(OrderStartApp.class,args);
    }
}
