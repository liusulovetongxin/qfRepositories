package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/5/23 21:01
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {

    private Long id;

    @JsonProperty(value = "username") //修改属性的名字为username,也是针对解析和返回同时生效
    private String userName;

    @JsonIgnore
    private String password;

    private int age;

    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")//设置数据的格式化的格式.针对解析和返回同时生效
    private Date birthday;
}
