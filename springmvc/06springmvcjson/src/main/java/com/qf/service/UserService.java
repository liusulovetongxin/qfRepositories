package com.qf.service;

import com.qf.pojo.User;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.service
 * @Description:
 * @Date 2022/5/21 0:54
 */

public interface UserService {
    User findByName(String username);

}
