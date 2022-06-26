package com.qf.simple;

import com.qf.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 * @version V1.0
 * @Project rabbitmqdemo
 * @Package com.qf
 * @Description:
 * @Date 2022/6/22 12:28
 */

public class Sender {
    private final String QUEUE_NAME = "WoDeDuiLie";

    @Test
    public void testSender() throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "我nima";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes(StandardCharsets.UTF_8));
        channel.close();
        connection.close();
    }

}
