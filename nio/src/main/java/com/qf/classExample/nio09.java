package com.qf.classExample;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/7/4 17:25
 */

public class nio09 {
    public static void main(String[] args)throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("test1.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 3);
        mappedByteBuffer.put(2, (byte) 'u');
        randomAccessFile.close();
    }

}
