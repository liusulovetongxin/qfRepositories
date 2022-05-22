package com.qf.service;

import com.qf.pojo.TbUser;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project ssmtest2
 * @Package com.qf.service
 * @Description:
 * @Date 2022/5/22 16:35
 */

public interface UserService {
        List<TbUser> findAll();

        void addUser(TbUser user);
}
