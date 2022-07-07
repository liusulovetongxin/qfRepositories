package com.qf.test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.qf.netty.proto.Student;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.test
 * @Description:
 * @Date 2022/7/7 18:47
 */

public class TestProtocol {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Student student =Student.newBuilder()
                .setName("张三")
                .setAge(18)
                .setAddress("北京")
                .build();

        byte[] byteArray = student.toByteArray();
        Student parseFrom = Student.parseFrom(byteArray);

        System.err.println(parseFrom.getName());
        System.err.println(parseFrom.getAge());
        System.err.println(parseFrom.getAddress());
    }
}
