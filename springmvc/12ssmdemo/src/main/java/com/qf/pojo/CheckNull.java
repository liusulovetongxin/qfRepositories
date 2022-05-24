package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/5/24 11:47
 */

public interface CheckNull {
    @JsonIgnore
    default boolean isEmpty(CheckType type){
        return false;
    };
}
