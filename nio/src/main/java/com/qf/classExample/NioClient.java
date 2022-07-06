package com.qf.classExample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package com.qf.classExample
 * @Description:
 * @Date 2022/7/5 19:57
 */

public class NioClient {

    public static void main(String[] args)throws Exception {
        // 获取selector
        Selector selector = Selector.open();
        // 获取通道
        SocketChannel socketChannel = SocketChannel.open();
        //非阻塞,绑定
        socketChannel.configureBlocking(false);
        // 注册
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        //连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1",23456));

        while (true){
            int select = selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                SelectableChannel channel = selectionKey.channel();
                if (selectionKey.isConnectable()) {
                    if (((SocketChannel) channel).isConnectionPending()) {
                        try {
                            socketChannel.finishConnect();
//                            ByteBuffer buffer = ByteBuffer.allocate(1024);
//                            buffer.put((((SocketChannel) channel).getRemoteAddress() + "上线了").getBytes("gbk"));
//                            buffer.flip();
//                            socketChannel.write(buffer);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            sendMsg(socketChannel);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else if (selectionKey.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (true){
                        try {
                            buffer.clear();
                            int read = ((SocketChannel) channel).read(buffer);
                            if (read>0){
                                buffer.flip();
                                System.err.println(Charset.forName("gbk").decode(buffer));
                            }
                            break;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            });
            selectionKeys.clear();
        }
    }
    public static void sendMsg(SocketChannel socketChannel){
        new Thread(){
            @Override
            public void run() {
                try {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    Scanner scanner = new Scanner(System.in);
                    while (scanner.hasNext()){
                        buffer.clear();
                        String msg = scanner.nextLine();
                        buffer.put(msg.getBytes("gbk"));
                        buffer.flip();
                        socketChannel.write(buffer);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }
}
