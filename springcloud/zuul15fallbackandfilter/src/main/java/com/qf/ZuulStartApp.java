package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf
 * @Description:
 * @Date 2022/6/27 19:51
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulStartApp {
    public static void main(String[] args){
        SpringApplication.run(ZuulStartApp.class,args);
    }
}
