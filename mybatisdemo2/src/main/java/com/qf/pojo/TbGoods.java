package com.qf.pojo;


public class TbGoods {

  private Long id;
  private String name;
  private java.util.Date pubdate;
  private String picture;
  private Double price;
  private Long star;
  private String intro;
  private Long typeid;


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


  public java.util.Date getPubdate() {
    return pubdate;
  }

  public void setPubdate(java.util.Date pubdate) {
    this.pubdate = pubdate;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }


  public Long getStar() {
    return star;
  }

  public void setStar(Long star) {
    this.star = star;
  }


  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }


  public Long getTypeid() {
    return typeid;
  }

  public void setTypeid(Long typeid) {
    this.typeid = typeid;
  }

  @Override
  public String toString() {
    return "TbGoods{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pubdate=" + pubdate +
            ", picture='" + picture + '\'' +
            ", price=" + price +
            ", star=" + star +
            ", intro='" + intro + '\'' +
            ", typeid=" + typeid +
            '}';
  }
}
