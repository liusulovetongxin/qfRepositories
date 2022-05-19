package com.qf.mapper;

import com.qf.pojo.TbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/19 15:08
 */

public interface UserMapper {
    @Select("select * from tb_user where id = #{id}")
    TbUser findById(@Param("id") Long id);

    @Select("select * from tb_user")
    List<TbUser> findAll();

    List<TbUser> findByLikeName(@Param("likeName") String likeName);

    void addUser( TbUser tbUser);
}
