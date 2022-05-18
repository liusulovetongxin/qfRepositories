package com.qf.pojo;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/5/18 12:03
 */

public class Person {
    private String name;

    private String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
