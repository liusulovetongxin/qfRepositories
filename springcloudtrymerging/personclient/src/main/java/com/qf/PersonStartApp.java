package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf
 * @Description:
 * @Date 2022/6/28 21:17
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.qf.mapper")
@EnableTransactionManagement
@EnableFeignClients
@EnableCircuitBreaker
public class PersonStartApp {
    public static void main(String[] args){
        SpringApplication.run(PersonStartApp.class,args);
    }
}
