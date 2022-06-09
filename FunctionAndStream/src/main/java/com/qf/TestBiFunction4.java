package com.qf;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 19:02
 */

public class TestBiFunction4 {
    public static void main(String[] args) {
        BiFunction<String,String,Integer> biFunction1 = new BiFunction<String, String, Integer>() {
            @Override
            public Integer apply(String s, String s2) {
                return s.length()+s2.length();
            }
        };

        System.err.println(biFunction1.apply("asd", "asda"));

        // 效果是一样的，不过不加括号的话是可以不加return的
        BiFunction<String,String,Integer> biFunction2 = (first,second)->first.length()+second.length();
        BiFunction<String,String,Integer> biFunction3 = (first,second)->{return first.length()+second.length();};

        System.err.println(biFunction2.apply("asd22", "asda"));
        System.err.println(biFunction3.apply("asd124", "asda"));

        // BiFunction和普通的也是可以结合使用的，但是要注意顺序，因为返回值只有一个，所以不可以当bi的参数
        Function<Integer,Integer> function = param->param+1000;
        BiFunction<String,String,Integer> biFunction = (first,second)->first.length()+second.length();

        System.err.println(biFunction.andThen(function).apply("first", "second"));

    }
}
