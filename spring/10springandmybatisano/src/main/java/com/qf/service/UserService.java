package com.qf.service;

import com.qf.pojo.TbUser;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service
 * @Description:
 * @Date 2022/5/19 17:51
 */

public interface UserService {

    TbUser findById(Long id);
    void addUser(TbUser tbUser);
}
