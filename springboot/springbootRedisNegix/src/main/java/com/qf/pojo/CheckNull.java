package com.qf.pojo;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootRedisNegix
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/6/19 19:54
 */

public interface CheckNull {
    default boolean isEmpty(){return false;}
}
