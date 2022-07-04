package com.qf.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author Administrator
 * @version V1.0
 * @Project rabbitmqspringboot
 * @Package com.qf.config
 * @Description:
 * @Date 2022/6/28 11:08
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue duixiangmingzi(){
        return new Queue("xiaoxiduilie",false,false,false,null);
    }

    @Bean
    public Queue xiaoxiduiliework(){
        return new Queue("xiaoxiduiliework",false,false,false,null);
    }



    @Bean
    public Queue springbootFanoutQueue(){
        return new Queue("springbootFanoutQueue",false,false,false,null);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("jiaohuanji",false,false);
    }
    @Bean
    public Binding bindingQueue2FanOutExchange(Queue springbootFanoutQueue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(springbootFanoutQueue).to(fanoutExchange);
    }
}
