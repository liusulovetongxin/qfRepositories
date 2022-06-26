package com.qf.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.config
 * @Description:
 * @Date 2022/6/23 20:52
 */
@Configuration
public class MyRibbonConfig {
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
