package com.qf.pojo;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/5/18 11:59
 */

public class City {
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                '}';
    }
}
