package com.qf;

import java.util.function.Function;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 17:47
 */

public class TestFunction3 {
    public static void main(String[] args) {
        Function<String,Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                if (s==null){
                    return 0;
                }else {
                    return 1;
                }
            }
        };
        System.err.println(function1.apply(""));

        Function<String,Integer> function2 = param ->{
            if (param==null){
                return 0;
            }else {
                return 1;
            }
        };
        System.err.println(function2.apply("123"));
        Function<String,Integer> function3 = param ->{
            if (param!=null){
                return param.length();
            }else {
                return 1;
            }
        };
        System.err.println(function3.apply("123"));

        Function<Integer,Integer> function4 = param->{
          return param*20;
        };
        System.err.println(function4.apply(10));
        Function<Integer,Integer> function5 = param->{
            return param+100;
        };
        System.err.println(function5.apply(10));

        System.err.println(function4.andThen(function5).apply(10));
        System.err.println(function4.compose(function5).apply(10));


        //identity  传什么返回什么
        System.err.println(Function.identity().apply("qweqwe"));
    }



}
