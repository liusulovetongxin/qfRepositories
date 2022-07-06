package com.qf.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.websocket
 * @Description:
 * @Date 2022/7/6 19:50
 */

public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String text = msg.text();
        System.err.println("收到的数据是"+text);
        ctx.writeAndFlush(new TextWebSocketFrame("我靠，这是真的？"));
    }
}
