package com.qf.netty.proto.protoclient;

import com.qf.netty.proto.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.proto.protoclient
 * @Description:
 * @Date 2022/7/7 19:00
 */

public class MyClientHandler2 extends SimpleChannelInboundHandler<Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Student msg) throws Exception {
        System.err.println(msg.getName());
        System.err.println(msg.getAge());
        System.err.println(msg.getAddress());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Student student = Student.newBuilder().setName("张三")
                .setAddress("北京")
                .setAge(18).build();
        ctx.writeAndFlush(student);
    }
}
