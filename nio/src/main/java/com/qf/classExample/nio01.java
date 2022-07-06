package com.qf.classExample;

import java.nio.IntBuffer;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/7/4 15:41
 */

public class nio01 {


    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            intBuffer.put(i);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            int i = intBuffer.get();
            System.err.println("本次读到的数据是："+i);
        }
    }
}
