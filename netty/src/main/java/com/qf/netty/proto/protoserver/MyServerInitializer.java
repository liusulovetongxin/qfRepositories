package com.qf.netty.proto.protoserver;

import com.qf.netty.proto.Student;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.proto.protoserver
 * @Description:
 * @Date 2022/7/7 18:52
 */

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufDecoder(Student.getDefaultInstance()))
                .addLast(new ProtobufEncoder())
                .addLast(new MyProtoHandler());
    }
}
