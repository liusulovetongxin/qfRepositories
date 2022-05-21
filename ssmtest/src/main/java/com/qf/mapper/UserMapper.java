package com.qf.mapper;

import com.qf.pojo.TbUser;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project ssmtest
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/21 17:19
 */

public interface UserMapper {
    List<TbUser> findAll();
}
