package com.qf.pojo;

import java.util.Date;

/**
 * @author zhaojian
 */
public class User {

    private Integer id;
    private String name;
    private String password;
    private String sex;
    private Date birthday;
    private Date registTime;

    public UserDesc getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(UserDesc userDesc) {
        this.userDesc = userDesc;
    }

    private UserDesc userDesc;
   

    //无参构造（必备构造二选一）
    public User() {}

    public User(Integer id, String name, String password, String sex, Date birthday, Date registTime, UserDesc userDesc) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.registTime = registTime;
        this.userDesc = userDesc;
    }

    //全参构造（必备构造二选一）


    public User(Integer id, String name, String password, String sex, Date birthday, Date registTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.registTime = registTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", registTime=" + registTime +
                ", userDesc=" + userDesc +
                '}';
    }
}
