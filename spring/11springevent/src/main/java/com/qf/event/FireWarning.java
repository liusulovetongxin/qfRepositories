package com.qf.event;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.event
 * @Description:
 * @Date 2022/5/23 12:45
 */

public class FireWarning {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FireWarning{" +
                "address='" + address + '\'' +
                '}';
    }
}
