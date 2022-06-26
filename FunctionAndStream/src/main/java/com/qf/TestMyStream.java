package com.qf;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/11 17:37
 */

public class TestMyStream {
    public static void main(String[] args) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        List<TestData> dataList = new ArrayList<>();
        dataList.add(new TestData(1L, "zhangsan","",new TestData2(1L,"ceshi1")));
        dataList.add(new TestData(2L, "lisi","",new TestData2(2L,"ceshi2")));
        dataList.add(new TestData(3L, "wangwu","",new TestData2(3L,"ceshi3")));
        dataList.add(new TestData(4L, "zhaoliu","",new TestData2(4L,"ceshi4")));
        dataList.add(new TestData(5L, "biqi","",new TestData2(5L,"ceshi5")));
//        System.err.println(dataList);
//        dataList.stream().forEach(testData -> testData.setPassword(bc.encode(String.valueOf(testData.getId()))));
//        dataList.forEach(System.err::println);
//        dataList.stream().forEach(testData ->{
//                    System.err.println(bc.matches(testData.getId().toString(), testData.getPassword()));}
//                );

    }
}
