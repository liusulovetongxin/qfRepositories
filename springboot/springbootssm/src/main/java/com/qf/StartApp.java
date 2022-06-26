package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootssm
 * @Package com.qf
 * @Description:
 * @Date 2022/6/14 11:45
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.qf.mapper")
public class StartApp {
    public static void main(String[] args){
        SpringApplication.run(StartApp.class,args);
    }
}
