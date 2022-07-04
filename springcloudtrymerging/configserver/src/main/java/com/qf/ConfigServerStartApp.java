package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf
 * @Description:
 * @Date 2022/6/28 17:46
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerStartApp {
    public static void main(String[] args){
        SpringApplication.run(ConfigServerStartApp.class,args);
    }
}
