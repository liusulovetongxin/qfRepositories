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
 * @Date 2022/7/5 21:11
 */

public class NioServer2 {
    private static List<SocketChannel> allClients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //搞一个selector
        Selector selector = Selector.open();
        //搞一个server channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 23456));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //注册到selector,并且关注accept
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.err.println("服务器运行在23456端口");
        //循环
        while (true) {
            //看看有没有操作发生,没有操作就会进入等待状态,有就放行,返回的结果告诉我们有几个操作
            int select = selector.select();
            //获取到当前的所有的操作
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            selectionKeys.forEach(selectionKey -> {
                // return;//跳出当前循环,继续下次循环
                //想要跳出整个foreach通过抛出异常来跳出
                //获取到了有操作的通道
                SelectableChannel channel = selectionKey.channel();
                //如果收到的是连接类型的操作
                if (selectionKey.isAcceptable()) {
                    try {
                        //接受连接
                        SocketChannel socketChannel = ((ServerSocketChannel) channel).accept();
                        socketChannel.configureBlocking(false);//设置为非阻塞
                        //一旦建立连接后,当前的channel就会关注消息数据
                        //设置感兴趣的操作
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        //保存当前连接到集合
                        allClients.add(socketChannel);
                        System.err.println("客户端" + socketChannel.getRemoteAddress() + "建立连接了");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (selectionKey.isReadable()) {
                    //收到可以处理的消息了
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while (true) {
                        byteBuffer.clear();
                        try {
                            //读取数据
                            int read = ((SocketChannel) channel).read(byteBuffer);
                            if (read > 0) {
                                byteBuffer.flip();
                                String msg = String.valueOf(Charset.forName("gbk").decode(byteBuffer));
                                System.err.println("收到客户端" + ((SocketChannel) channel).getRemoteAddress() + "的消息:===>" + msg);
                                msg = "客户端" + ((SocketChannel) channel).getRemoteAddress() + "发送的消息:===>" + msg;
                                //清空数据,替换为我们自己要发送的数据
                                byteBuffer.clear();
                                //把我们要发送的数据写进去
                                byteBuffer.put(msg.getBytes("gbk"));
                                //翻转
                                byteBuffer.flip();
                                //发给其他所有的客户端
                                allClients.forEach(socketChannel -> {
                                    //不是自己
                                    if (!socketChannel.equals(channel)) {
                                        try {
                                            //进入重新读的状态,因为每一个客户端都要发一次,所以每次都要重置一下,不然就会被之前的占用光了
                                            byteBuffer.rewind();
                                            socketChannel.write(byteBuffer);
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
            //把之前的事情清理掉
            selectionKeys.clear();
        }
    }
}
