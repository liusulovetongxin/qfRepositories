package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootRedisNegix
 * @Package com.qf
 * @Description:
 * @Date 2022/6/18 13:47
 */
@SpringBootApplication
@MapperScan("com.qf.mapper")
public class StartApp {
    public static void main(String[] args){
        SpringApplication.run(StartApp.class,args);
    }
}
