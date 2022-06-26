package com.qf.mapper;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootRedisNegix
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/6/18 13:49
 */

public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);
}
