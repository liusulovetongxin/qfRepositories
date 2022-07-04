package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf
 * @Description:
 * @Date 2022/6/23 18:57
 */
@SpringBootApplication
@EnableCircuitBreaker
public class AddressStartApp {
    public static void main(String[] args){
        SpringApplication.run(AddressStartApp.class,args);
    }
}
