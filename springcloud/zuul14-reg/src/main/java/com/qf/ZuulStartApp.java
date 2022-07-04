package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/6/26 23:29
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulStartApp {
    public static void main(String[] args){
        SpringApplication.run(ZuulStartApp.class,args);
    }


    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }
}
