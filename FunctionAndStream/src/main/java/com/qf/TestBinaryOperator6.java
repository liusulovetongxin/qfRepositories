package com.qf;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 21:14
 */

public class TestBinaryOperator6 {
    public static void main(String[] args) {
//        BinaryOperator binaryOperator = new BinaryOperator() {
//            @Override
//            public Object apply(Object o, Object o2) {
//                return null;
//            }
//        } ;
        BinaryOperator<Integer> binaryOperator =(first,second)->first+second;
        System.err.println(binaryOperator.apply(123, 123));

        Comparator<String> comparable = (s1, s2) -> s1.compareTo(s2);
        System.err.println(BinaryOperator.maxBy(comparable).apply("123", "2123"));

        System.err.println(BinaryOperator.minBy(comparable).apply("123", "12"));

    }
}
