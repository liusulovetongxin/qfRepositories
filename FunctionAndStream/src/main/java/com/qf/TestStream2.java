package com.qf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/8 20:43
 */

public class TestStream2 {
    public static void main(String[] args) {
             // limit：取多少个，限定符
//        new Random().ints().limit(10).forEach(System.err::println);
//        Stream.of("1","22","333","abc","1","2","333","abc","4")
//        //去重
//        .distinct()
//        .forEach(System.err::println);
//
//        String result1 = Stream.of("1", "22", "333", "abc", "1", "2", "333", "abc", "4")
//                //获取到第一个数据
//                .findFirst()
//                //Optional中的方法
//                .get();
//        System.err.println(result1);
//        String result2 = Stream.of("1", "22", "333", "abc", "1", "2", "333", "abc", "4")
//                //找任意一个,具体的任意的选择标准取决于实际的实现
//                .findAny()
//                //Optional中的方法
//                .get();
//        System.err.println(result2);

        List<Grade> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Grade grade = new Grade();
            grade.setName("grade->" + i);
            List<Student> students = new ArrayList<>();
            for (int i1 = 0; i1 < 20; i1++) {
                Student student = new Student();
                student.setName(grade.getName() + "==>" + i1);
                student.setAge(i1 +i+ 10);
                students.add(student);
            }
            grade.setStudents(students);
            list.add(grade);
        }

        List<Student> studentList = list.stream()
                .flatMap(grade -> grade.getStudents().stream())
                .collect(Collectors.toList());
//        System.err.println(studentList);

        List<Character> collect = Stream.of("my name is zhangsan")
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .map(s -> s.chars().mapToObj(c -> (char) c))
                .flatMap(characterStream -> characterStream.map(
                        character -> character.charValue())).collect(Collectors.toList());
//        System.err.println(collect);
        //        //reduce,将我们的数据按照顺序传递到我们的函数中,并将返回结果和下一个数据当做参数继续传递到函数中,直到所有的数据都完成为止
        String s = Stream.of("1", "22", "333", "abc", "1", "2", "333", "abc", "4").reduce((s1, s2) -> s1 + s2).get();
        System.err.println(s);


        //anymatch 就是判断我们的数据中是不是有任意一个数据满足表达式
        boolean anyMatch = Stream.of("1", "22", "333", "abc", "1", "2", "333", "abc", "4").anyMatch(s1 -> s1.length() > 2);
//        System.err.println(anyMatch);
        //allMatch 就是判断我们的数据中是不是有全部都满足表达式
        boolean allMatch = Stream.of("1", "22", "333", "abc", "1", "2", "333", "abc", "4").allMatch(s1 -> s1.length() > 2);
//        System.err.println(allMatch);
        //判断所有的数据是不是都不符合要求
        boolean noneMatch = Stream.of("1", "22", "333", "abc", "1", "2", "333", "abc", "4").noneMatch(s1 -> s1.length() >3);
//        System.err.println(noneMatch);
        //sorted排序,会按照默认的顺序排序
        List<String> list1 = Stream.of("1", "22", "333", "abc", "1", "2", "333", "abc", "4").sorted().collect(Collectors.toList());
        //  System.err.println(list1);
        //会报错, 因为我们的Student没有实现比较的接口,无法按照默认的顺序进行排序,会抛出java.lang.ClassCastException: com.qf.function.Student cannot be cast to java.lang.Comparable
        //List<Student> studentList1 = studentList.stream().sorted().collect(Collectors.toList());
        //System.err.println(studentList1);
        // 自定义排序函数
        //我们可以带着自定义的排序函数来进行排序,方便我们自定义规则或者是当前类我们无法实现比较接口的时候
        List<Student> studentList1 = studentList.stream().sorted((student1, student2) -> student1.getAge() - student2.getAge()).collect(Collectors.toList());
//        System.err.println(studentList1);
        List<String> stringList = Stream.of("1", "22", "333", "abc", "1", "2", "333", "abc", "4").skip(2).limit(2).collect(Collectors.toList());
        // System.err.println(stringList);





    }


}
