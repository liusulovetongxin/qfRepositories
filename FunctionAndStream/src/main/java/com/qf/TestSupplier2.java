package com.qf;

import java.util.function.Supplier;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 17:43
 */

public class TestSupplier2 {
    public static void main(String[] args) {
        Supplier supplier1 =new Supplier() {
            @Override
            public Object get() {
                return "消费性接口1";
            }
        };
        System.err.println(supplier1.get());

        Supplier supplier2 =()->"消费性接口2";
        System.err.println(supplier2.get());
        // 也可以指定泛型
        Supplier<String> supplier3 = ()->"消费性接口3";
        System.err.println(supplier3.get());
    }
}
