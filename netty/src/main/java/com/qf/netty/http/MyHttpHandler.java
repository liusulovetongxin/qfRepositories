package com.qf.netty.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.http
 * @Description:
 * @Date 2022/7/6 16:29
 */

public class MyHttpHandler extends SimpleChannelInboundHandler<HttpObject> {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.err.println("MyHttpHandler类中的channelRead0方法执行了-->");
        if (msg instanceof  HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            String uri = httpRequest.uri();
            String path = uri;
//            System.err.println(uri);
            Map<Object, Object> paramMap = new HashMap<>();
            if (uri.contains("?")) {
               path = uri.split("\\?")[0];
//                System.err.println(path);
                String queryString = uri.split("\\?")[1];
                String[] split = queryString.split("&");
                for (String s : split) {
                    String[] split1 = s.split("=");
                    paramMap.put(split1[0],split1[1]);
                }
            }
            System.err.println(paramMap);

            Method method = AnnotationUtil.getMethod(path);
            if (method != null) {
                Parameter[] parameters = method.getParameters();
                Object[] params = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    String param = parameters[i].getName();
                    params[i] = paramMap.get(param);
                }
                Object controller = AnnotationUtil.getObject(path);
//                System.err.println(params);
                Object result = method.invoke(controller, params);
//                System.err.println("返回结果是："+result);
                String json = objectMapper.writeValueAsString(result);
                ByteBuf byteBuf = Unpooled.copiedBuffer(json.getBytes(StandardCharsets.UTF_8));
                HttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,byteBuf);
                httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"application/json");
                ctx.writeAndFlush(httpResponse);
                ctx.close();
            }

        }

    }
}
