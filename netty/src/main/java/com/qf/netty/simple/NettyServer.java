package com.qf.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.simple
 * @Description:
 * @Date 2022/7/6 10:46
 */

public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup parent = new NioEventLoopGroup();
        EventLoopGroup child = new NioEventLoopGroup();
        serverBootstrap
                .group(parent,child)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,128)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });

        try {
            ChannelFuture channelFuture = serverBootstrap.bind(12345).sync();
            channelFuture.addListener(future -> {
                if (future.isSuccess()){
                    System.err.println("服务端启动成功");
                }else{
                    System.err.println("服务端启动失败");
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
            if (child!=null){
                child.shutdownGracefully();
            }
        }
    }
}
