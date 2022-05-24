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
 * @Date 2022/5/24 19:32
 */

public interface TUserMapper {

    @Insert("INSERT INTO tb_user(username,password,email,gender,flag,`role`,code) values (#{username},#{password},#{email},#{gender},#{flag},#{role},#{code})")
    void addUser(TbUser tbUser);

    int updateUser(TbUser tbUser);

    @Select("select * from tb_user")
    List<TbUser> findAll();

    @Select("select * from tb_user where id = #{id}")
    TbUser findById(Long id);
    @Select("SELECT * FROM tb_user WHERE username =#{username}")
    TbUser findByUserName(String userName);
}
