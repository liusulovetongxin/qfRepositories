package com.qf.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.websocket
 * @Description:
 * @Date 2022/7/6 19:44
 */

public class MyWebSocketServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup parent = new NioEventLoopGroup();
        NioEventLoopGroup child = new NioEventLoopGroup();
        serverBootstrap
//                .handler(new LoggingHandler(LogLevel.INFO))
                .group(parent, child)
                .channel(NioServerSocketChannel.class)
                .childHandler(new MyWebSocketInitializer());

        try {
            ChannelFuture channelFuture = serverBootstrap.bind(12345).sync();
            channelFuture.addListener(future -> {
                if (future.isSuccess()){
                    System.err.println("服务器启动成功");
                }else {
                    System.err.println("服务器启动失败");
                }
            });
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (parent != null) {
                parent.shutdownGracefully();
            }
            if (child != null) {
                child.shutdownGracefully();
            }
        }
    }
}
