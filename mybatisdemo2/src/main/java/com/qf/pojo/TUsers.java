package com.qf.pojo;

import java.util.Date;
public class TUsers {

  private Long id;
  private String name;
  private String password;
  private String sex;
  private Date birthday;
  private Date registTime;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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


  public java.util.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.util.Date birthday) {
    this.birthday = birthday;
  }


  public java.util.Date getRegistTime() {
    return registTime;
  }

  public void setRegistTime(java.util.Date registTime) {
    this.registTime = registTime;
  }

  @Override
  public String toString() {
    return "TUsers{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", sex='" + sex + '\'' +
            ", birthday=" + birthday +
            ", registTime=" + registTime +
            '}';
  }
}
