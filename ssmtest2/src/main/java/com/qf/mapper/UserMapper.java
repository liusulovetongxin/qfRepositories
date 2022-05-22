package com.qf.mapper;

import com.qf.pojo.TbUser;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project ssmtest2
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/22 16:35
 */

public interface UserMapper {
    List<TbUser> selectAll();

    void insertUser(TbUser user);
}
