package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.TbUser;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.service
 * @Description:
 * @Date 2022/5/24 19:35
 */

public interface TUserService {
    void addUser(TbUser tbUser);

    int updateUser(TbUser tbUser);

    PageInfo<TbUser> findAll(int pageNum,int pageSize);

    TbUser findById(Long id);

    TbUser findByUserName(TbUser user);
}
