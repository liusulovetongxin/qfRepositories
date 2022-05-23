package com.qf.mapper;

import com.qf.pojo.TbUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/23 23:10
 */

public interface UserMapper {
    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    TbUser findById(Long id);

    @Select("SELECT * FROM tb_user")
    List<TbUser> findAll();

    @Insert("INSERT INTO tb_user (username,password,email,gender,flag,role,code) values(#{username},#{password},#{email},#{gender},#{flag},#{role},#{code})")
    void addUser(TbUser tbUser);
}
