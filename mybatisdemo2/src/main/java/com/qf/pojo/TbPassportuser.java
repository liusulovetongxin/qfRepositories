package com.qf.pojo;


public class TbPassportuser {

  private Long id;
  private String name;
  private String sex;

  private TbPassport tbPassport;


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


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public TbPassport getTbPassport() {
    return tbPassport;
  }

  public void setTbPassport(TbPassport tbPassport) {
    this.tbPassport = tbPassport;
  }

  @Override
  public String toString() {
    return "TbPassportuser{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", tbPassport=" + tbPassport +
            '}';
  }
}
