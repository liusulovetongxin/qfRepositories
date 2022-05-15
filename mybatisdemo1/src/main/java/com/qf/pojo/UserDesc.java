package com.qf.pojo;

/**
 * @author zhaojian
 */
public class UserDesc {

    public Integer id;
    public String address;
    public Integer phoneNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "UserDesc{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}
