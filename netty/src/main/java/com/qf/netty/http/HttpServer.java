package com.qf.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.http
 * @Description:
 * @Date 2022/7/6 16:25
 */

public class HttpServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup parent = new NioEventLoopGroup();
        NioEventLoopGroup child = new NioEventLoopGroup();
        serverBootstrap
                .group(parent,child)
                .channel(NioServerSocketChannel.class)
                .childHandler(new HttpInitializer());
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(12345).sync();
            channelFuture.addListener(future -> {
               if (future.isSuccess()){
                   AnnotationUtil.inject();
                   System.err.println("服务器启动成功");
               }else{
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
                parent.shutdownGracefully();
            }
        }

    }
}
