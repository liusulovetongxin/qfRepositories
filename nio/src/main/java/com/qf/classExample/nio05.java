package com.qf.classExample;

import java.nio.ByteBuffer;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/7/4 17:09
 */

public class nio05 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.putInt(1);
        buffer.putChar('1');
        buffer.putLong(1234L);
        buffer.putDouble(3.14);
        buffer.putFloat(0.15926f);
        buffer.flip();
        System.err.println(buffer.getInt());
        System.err.println(buffer.getChar());
        System.err.println(buffer.getLong());
        System.err.println(buffer.getDouble());
        //如果超出了长度,会提示BufferUnderflowException
        System.err.println(buffer.getFloat());
    }
}
