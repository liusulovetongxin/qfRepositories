package com.qf.mapper;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Administrator
 * @version V1.0
 * @Project MySSMdemo1
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/25 1:18
 */

public interface UserMapper {
    @Insert("insert into user values(null,#{username},#{password},#{realname},#{email},#{gender},#{flag},#{role})")
    void addUser(User user);
}
