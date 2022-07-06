package com.qf;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package com.qf
 * @Description:
 * @Date 2022/7/4 21:01
 */

public class test01 {

    @Test
    public void test1()throws Exception{
        RandomAccessFile raf = new RandomAccessFile("D:\\DeskTop\\记事本.txt","rw");
        FileChannel channel = raf.getChannel();
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,0,6);
        buffer.put(0, (byte) 'G');
        buffer.put(1, (byte) 'o');
        buffer.put(2, (byte) 'o');
        buffer.put(3, (byte) 'g');
        buffer.put(4, (byte) 'l');
        buffer.put(5, (byte) 'e');
        raf.close();
    }

    @Test
    public void test2()throws Exception{
        FileOutputStream fos = new FileOutputStream("testfrom.txt");
        FileChannel channel = fos.getChannel();
        String s = "今天有没有导医看";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(s.getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        channel.write(buffer);
        fos.close();
    }


    @Test
    public  void test3()throws Exception{
        FileInputStream fis = new FileInputStream("testfrom.txt");
        FileChannel fisChannel = fis.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileOutputStream fos = new FileOutputStream("testto.txt");
        FileChannel fosChannel = fos.getChannel();
        while (true){
//            buffer.clear();
            int read = fisChannel.read(buffer);
            if (read==-1){
                break;
            }
            buffer.flip();
            fosChannel.write(buffer);
        }
        fis.close();
        fos.close();
    }







}
