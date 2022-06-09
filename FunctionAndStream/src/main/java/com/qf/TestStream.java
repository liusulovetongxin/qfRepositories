package com.qf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 20:15
 */

public class TestStream {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhaoliu");

//        System.err.println(list);

        List<Integer> integerList = list.stream()
                .map(String::length)
                //相当于
//                .map(s->s.length())
                .collect(Collectors.toList());
        System.err.println(integerList);
        List<String> stringList = list.parallelStream()
                .map(s -> s + "pinjie")
                .collect(Collectors.toList());
        System.err.println(stringList);

        //stream是一个一个迭代，parallelStream是多线程的
        System.err.println(list.parallelStream()
                .map(
                        s -> {
                            try {
                                Thread.sleep(2000);

                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            return s.length();
                        }
                ).collect(Collectors.toList()));

        String[] sss ={"23123","12fasf","asdas","wgdfasf"};
        Arrays.stream(sss)
                .parallel()// 并行
                .forEach(System.err::println);
        Arrays.stream(sss)
                .parallel()
                .forEachOrdered(System.err::println);// 重新回到串行
        Arrays.stream(sss).sequential();// 串行，默认就是串行

        // forEach是一个终止符，到此结束，后面不再做别的
        // peel和foreach一样，但是不是终止符，不会结束
        List<String> collect = Arrays.stream(sss)
                .parallel()
                .peek(System.err::println)
                .filter(s -> s.length() > 5)
                .limit(1)
                .collect(Collectors.toList());
        System.err.println(collect);
    }
}
