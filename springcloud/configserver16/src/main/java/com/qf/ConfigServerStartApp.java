package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf
 * @Description:
 * @Date 2022/6/27 20:57
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerStartApp {
    public static void main(String[] args){
        SpringApplication.run(ConfigServerStartApp.class,args);
    }
}
