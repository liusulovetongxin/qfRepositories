package com.qf.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.http
 * @Description:
 * @Date 2022/7/6 16:27
 */

public class HttpInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new HttpServerCodec())
                .addLast(new MyHttpHandler());
    }
}
