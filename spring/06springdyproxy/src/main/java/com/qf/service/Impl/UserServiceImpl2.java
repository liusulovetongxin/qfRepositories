package com.qf.service.Impl;

import com.qf.service.UserService;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.Impl
 * @Description:
 * @Date 2022/5/18 20:37
 */

public class UserServiceImpl2 implements UserService {
    @Override
    public String addUser() {
        System.err.println("UserServiceImpl2类中的addUser方法执行了-->");
        System.err.println("模拟进行添加用户操作");
        System.err.println("添加用户成功");
        return "添加用户成功";
    }

    @Override
    public void updateUser() {
        System.err.println("UserServiceImpl2类中的updateUser方法执行了-->");
        System.err.println("模拟进行修改用户操作");
        System.err.println("修改用户成功");
    }
}
