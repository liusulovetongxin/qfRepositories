package com.qf.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.simple
 * @Description:
 * @Date 2022/7/6 19:27
 */

public class NettyClient {
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup child = new NioEventLoopGroup();
        bootstrap
                .group(child)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyClientHandler());
                    }
                })

        ;
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 12345);
        try{
            channelFuture.channel().closeFuture().sync();
            }catch(Exception e){
            e.printStackTrace();
            }finally {
            if (child != null) {
                child.shutdownGracefully();
            }
        }
    }


}
