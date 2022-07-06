package com.qf.classExample;

import java.nio.ByteBuffer;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/7/4 17:17
 */

public class nio07 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }
        ByteBuffer newBuffer = buffer.asReadOnlyBuffer();
        newBuffer.put(0, (byte) 1);
        buffer.put(0, (byte) 1);

    }
}
