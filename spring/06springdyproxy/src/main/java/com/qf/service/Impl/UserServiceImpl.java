package com.qf.service.Impl;

import com.qf.service.UserService;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.Impl
 * @Description:
 * @Date 2022/5/18 15:16
 */

public class UserServiceImpl implements UserService {
    @Override
    public String addUser() {
        System.err.println("UserServiceImpl类中的addUser方法执行了-->");
        return null;
    }

    @Override
    public void updateUser() {
        System.err.println("UserServiceImpl类中的updateUser方法执行了-->");
    }
}
