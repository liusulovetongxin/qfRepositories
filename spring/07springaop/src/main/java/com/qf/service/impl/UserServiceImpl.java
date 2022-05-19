package com.qf.service.impl;

import com.qf.service.UserService;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/19 10:42
 */

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.err.println("UserServiceImpl类中的addUser方法执行了-->");
    }

    @Override
    public String updateUser() {
        System.err.println("UserServiceImpl类中的updateUser方法执行了-->");
        return "updateUser";
    }
}
