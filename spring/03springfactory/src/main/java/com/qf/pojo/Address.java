package com.qf.pojo;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/5/18 11:59
 */

public class Address {
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                '}';
    }
}
