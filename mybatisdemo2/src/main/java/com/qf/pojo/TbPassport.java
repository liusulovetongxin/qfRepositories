package com.qf.pojo;


public class TbPassport {

  private Long id;
  private String passport;
  private Long passportid;
  private Long uid;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getPassport() {
    return passport;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }


  public Long getPassportid() {
    return passportid;
  }

  public void setPassportid(Long passportid) {
    this.passportid = passportid;
  }


  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  @Override
  public String toString() {
    return "TbPassport{" +
            "id=" + id +
            ", passport='" + passport + '\'' +
            ", passportid=" + passportid +
            ", uid=" + uid +
            '}';
  }
}
