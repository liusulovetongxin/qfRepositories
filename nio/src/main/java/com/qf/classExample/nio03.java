package com.qf.classExample;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/7/4 15:51
 */

public class nio03 {
    public static void main(String[] args)throws Exception {
        String s  = "zhe shi ce shi xie ru de shu ju.";
        FileOutputStream fileOutputStream = new FileOutputStream("testout.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(s.getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        channel.write(buffer);
        fileOutputStream.close();
    }
}
