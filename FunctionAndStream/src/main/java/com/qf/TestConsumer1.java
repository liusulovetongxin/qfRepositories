package com.qf;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 17:35
 */

public class TestConsumer1 {
    public static void main(String[] args) {
        Consumer consumer1 = new Consumer() {
            @Override
            public void accept(Object o) {
                System.err.println(o);
            }
        };
        consumer1.accept("消费性接口1");
        Consumer consumer2 = s-> System.err.println(s);
        consumer2.accept("消费性接口2");
        Consumer consumer3 = System.err::println;
        consumer3.accept("消费性接口3");
        consumer3.accept(123);

        Consumer<Integer> integerConsumer = System.err::println;
        integerConsumer.accept(123123);


        BiConsumer<String,String> biConsumer = (first,second)->{
            System.err.println(first+""+second);
        };
        biConsumer.accept("第一个参数", "第二个参数");
    }
}
