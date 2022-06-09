package com.qf;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 21:23
 */

public class TestMyFunction {
    public static void main(String[] args) {
//        MyFunction<String,Integer> myFunction = new MyFunction<String, Integer>() {
//            @Override
//            public Integer fangfaming(String s) {
//                return s.length();
//            }
//        };
//        System.err.println(myFunction.fangfaming("123123"));

        MyFunction<String,Integer> myFunction = s->s.length();
        System.err.println(myFunction.fangfaming("1213"));
    }
}
