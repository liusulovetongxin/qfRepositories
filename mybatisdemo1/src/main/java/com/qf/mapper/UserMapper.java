package com.qf.mapper;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo1
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/12 9:46
 */

public interface UserMapper  {
    public List<User> findAll();

    public User findById(@Param("id") Integer id);

    public List<User> findLike(@Param("likeName")String likeName);
    void insertInto(User user);
}
