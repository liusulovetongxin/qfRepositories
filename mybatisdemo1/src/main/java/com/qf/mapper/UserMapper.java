package com.qf.mapper;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    public void insertInto(@Param("user") User user);
    public void updateUserById(@Param("user") User user);
    public void deleteById(@Param("id")Integer id);
    public User selectByNameAndPwd(@Param("name")String name,@Param("password")String password);
    public User selectByNameAndPwdMap(@Param("map")Map<String,String> map);
    public void deleteByName(@Param("name")String name);
}
