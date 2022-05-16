package com.qf.pojo;


public class TbOrder {

  private String id;
  private Long uid;
  private Double money;
  private String status;
  private java.util.Date time;
  private Long aid;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }


  public Double getMoney() {
    return money;
  }

  public void setMoney(Double money) {
    this.money = money;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public java.util.Date getTime() {
    return time;
  }

  public void setTime(java.util.Date time) {
    this.time = time;
  }


  public Long getAid() {
    return aid;
  }

  public void setAid(Long aid) {
    this.aid = aid;
  }

}
