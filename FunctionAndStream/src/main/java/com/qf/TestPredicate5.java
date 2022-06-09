package com.qf;

import java.util.function.Predicate;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 19:58
 */

public class TestPredicate5 {
    public static void main(String[] args) {
        Predicate predicate1 = new Predicate() {
            @Override
            public boolean test(Object o) {
                return o==null;
            }
        };
        System.err.println(predicate1.test("zhangsan"));
        System.err.println(predicate1.test(""));
        System.err.println(predicate1.test(null));

        Predicate<String> predicate2 = s->s!=null;
        System.err.println(predicate2.test("zhangsan"));
        System.err.println(predicate2.test(""));

        Predicate<String> predicate3 = s->s!="";
        System.err.println(predicate3.test("zhangsan"));
        System.err.println(predicate3.test(""));

        Predicate<String> predicate4 = s -> !s.trim().equals("");
        System.err.println(predicate4.test(""));
        System.err.println(predicate4.test("  "));

        System.err.println(predicate1.and(predicate2.and(predicate3)).test("null"));
        //会出现空指针
          System.err.println(predicate1.and(predicate2).test(null));
        //这个是取反
        System.err.println(predicate1.negate().test(null));
    }
}
