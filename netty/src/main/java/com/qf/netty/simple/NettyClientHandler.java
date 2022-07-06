package com.qf.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.simple
 * @Description:
 * @Date 2022/7/6 19:30
 */

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.err.println("NettyClientHandler类中的channelActive方法执行了-->");
        ctx.writeAndFlush(Unpooled.copiedBuffer("我草你嘛".getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String s = ((ByteBuf) msg).toString(StandardCharsets.UTF_8);
        System.err.println("服务器说："+s);
        int i = new Random().nextInt(10);
        if (i==1){
            return;
        }
        ctx.writeAndFlush(Unpooled.copiedBuffer("我草你嘛".getBytes(StandardCharsets.UTF_8)));

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
