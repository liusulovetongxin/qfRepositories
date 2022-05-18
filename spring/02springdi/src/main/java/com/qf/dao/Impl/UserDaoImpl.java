package com.qf.dao.Impl;

import com.qf.dao.UserDao;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.dao.Impl
 * @Description:
 * @Date 2022/5/18 12:05
 */

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.err.println("UserDaoImpl中的addUSer 执行了");
    }
}
