package com.qf.service;

import com.qf.pojo.TbUser;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project ssmtest
 * @Package com.qf.service
 * @Description:
 * @Date 2022/5/21 17:23
 */

public interface UserService {
    List<TbUser> findAll();
}
