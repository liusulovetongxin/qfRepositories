package com.qf.classExample;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/7/4 15:46
 */

public class nio02 {
    public static void main(String[] args)throws Exception {
        FileInputStream fileInputStream = new FileInputStream("test1.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            byte b = buffer.get();
            System.err.print((char)b);
        }
    }
}
