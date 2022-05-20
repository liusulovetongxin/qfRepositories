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
 * @Date 2022/5/21 0:55
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    @JsonProperty(value = "username") // 修改属性的名字为username
    private String username;
    @JsonIgnore  //忽略掉此属性
    private String password;
    private int age;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")// 格式化
    private Date brithday;
}
