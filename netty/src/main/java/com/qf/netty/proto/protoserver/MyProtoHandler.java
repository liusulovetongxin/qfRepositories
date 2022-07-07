package com.qf.netty.proto.protoserver;

import com.qf.netty.proto.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.proto.protoserver
 * @Description:
 * @Date 2022/7/7 18:54
 */

public class MyProtoHandler extends SimpleChannelInboundHandler<Student> {
    private Set<ChannelHandlerContext> ctxs = new HashSet<>();

    private Map<ChannelId,ChannelHandlerContext> map = new HashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Student msg) throws Exception {
        System.err.println("MyProtoHandler类中的channelRead0方法执行了-->");
        System.err.println(msg.getName());
        System.err.println(msg.getAge());
        System.err.println(msg.getAddress());

        Student student = Student
                .newBuilder()
                .setName("李四")
                .setAge(18)
                .setAddress("济南").build();
        System.err.println(map);
        Set<ChannelId> channelIds = map.keySet();
        channelIds.remove(ctx.channel().id());
        channelIds.forEach(channelId -> {
            map.get(channelId).writeAndFlush(student);
        });

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("MyProtoHandler类中的channelActive方法执行了-->");
        ctxs.add(ctx);
        System.err.println(ctx.name());
        System.err.println(ctx.channel().id());
        map.put(ctx.channel().id(), ctx);
    }
}
