package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf
 * @Description:
 * @Date 2022/6/23 19:47
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerStartApp {
    public static void main(String[] args){
        SpringApplication.run(EurekaServerStartApp.class,args);
    }
}
