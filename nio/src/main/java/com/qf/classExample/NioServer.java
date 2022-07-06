package com.qf.classExample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package com.qf.classExample
 * @Description:
 * @Date 2022/7/5 16:55
 */

public class NioServer {

    private static List<SocketChannel> allClient = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        // 获取到一个selector
        Selector  selector = Selector.open();
        //获取到通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定ip
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",23456));
        //设置为非阻塞的
        serverSocketChannel.configureBlocking(false);
        //注册到selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.err.println("服务器启动成功并且运行在23456端口");
        // 死循环一下
        while (true){
            // 这个是一个阻塞方法，当没有的时候会阻塞
            int select = selector.select();
            //获取到selectionKeys
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 循环遍历，
            selectionKeys.forEach(selectionKey -> {
                SelectableChannel channel = selectionKey.channel();
                if (selectionKey.isAcceptable()){
                    try {
                        SocketChannel socketChannel = ((ServerSocketChannel) channel).accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        allClient.add(socketChannel);
                        System.err.println(socketChannel.getRemoteAddress()+"上线了");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (selectionKey.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (true){
                        buffer.clear();
                        try {
                            int read = ((SocketChannel) channel).read(buffer);
                            if (read>0){
                                buffer.flip();
                                String gbk = Charset.forName("gbk").decode(buffer).toString();
                                System.err.println(gbk);
                                String msg = ((SocketChannel) channel).getRemoteAddress()+"说:"+ gbk;
                                buffer.clear();
                                buffer.put(msg.getBytes("gbk"));
                                buffer.flip();
                                // 找到所有的客户端
                                allClient.forEach(socketChannel -> {
                                    if (!socketChannel.equals(channel)) {
                                        try {
                                            buffer.rewind();
                                            socketChannel.write(buffer);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                });
                            }else {
                                break;
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            selectionKeys.clear();
        }
    }
}
