package com.qf.controller;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Administrator
 * @version V1.0
 * @Project rabbitmqspringboot
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/6/28 10:37
 */
@RestController
public class TestController {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/one2one")
    public String sendMessage(String msg){
        rabbitTemplate.convertAndSend("xiaoxiduilie",msg);
        return "success";
    }

    @GetMapping("/one2more")
    public String sendMessage2Exchange(String msg){
        CorrelationData messageId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("jiaohuanji","", msg, messageId);
        return "success";
    }
}
