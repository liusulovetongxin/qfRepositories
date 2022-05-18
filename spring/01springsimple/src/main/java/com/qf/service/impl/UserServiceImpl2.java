package com.qf.service.impl;

import com.qf.service.UserService;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/17 16:24
 */

public class UserServiceImpl2 implements UserService {
    @Override
    public void addUser(String username) {
        System.err.println("UserServiceImpl2运行了,"+username);
    }
}
