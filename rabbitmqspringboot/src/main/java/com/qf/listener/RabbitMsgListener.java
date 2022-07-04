package com.qf.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version V1.0
 * @Project rabbitmqspringboot
 * @Package com.qf.listener
 * @Description:
 * @Date 2022/6/28 11:00
 */
@Component
public class RabbitMsgListener {
    @RabbitListener(queues = {"xiaoxiduilie"})
    public void onMessage(String msg){
        System.err.println("收到的消息是："+msg);
    }


    @RabbitListener(queues = {"springbootFanoutQueue"})
    public void onMessage1(String msg, Message message, Channel channel) throws Exception{
        System.err.println("springboot收到的消息是："+msg);
        //获取生产者发送的id
        Object id = message.getMessageProperties().getHeader("spring_returned_message_correlation");

        System.err.println(id);
        //应答
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
