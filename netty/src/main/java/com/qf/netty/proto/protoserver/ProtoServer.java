package com.qf.netty.proto.protoserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.proto.protoserver
 * @Description:
 * @Date 2022/7/7 18:50
 */

public class ProtoServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup parent = new NioEventLoopGroup();
        NioEventLoopGroup child = new NioEventLoopGroup();
        serverBootstrap
                .group(parent, child)
                .channel(NioServerSocketChannel.class)
                .childHandler(new MyServerInitializer());
        try{
            ChannelFuture channelFuture = serverBootstrap.bind(12345).sync();
            channelFuture.channel().closeFuture().sync();
        }catch(Exception e){
            e.printStackTrace();
            }
        finally {
            parent.shutdownGracefully();
            child.shutdownGracefully();
        }
    }
}
