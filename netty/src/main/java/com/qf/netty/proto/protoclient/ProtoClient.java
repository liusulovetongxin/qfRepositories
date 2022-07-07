package com.qf.netty.proto.protoclient;

import com.qf.netty.proto.Student;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.proto.protoclient
 * @Description:
 * @Date 2022/7/7 18:58
 */

public class ProtoClient {
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup eventExecutor = new NioEventLoopGroup();
        bootstrap.group(eventExecutor)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder())
                                .addLast(new ProtobufVarint32LengthFieldPrepender())
                                .addLast(new ProtobufDecoder(Student.getDefaultInstance()))
                                .addLast(new ProtobufEncoder())
                                .addLast(new MyClientHandler());
                    }
                });
        try{
            ChannelFuture channelFuture = bootstrap.connect("localhost", 12345).sync();
            channelFuture.channel().closeFuture().sync();
        }catch(Exception e){
            e.printStackTrace();
            }
        finally {
            eventExecutor.shutdownGracefully();
        }
    }
}
