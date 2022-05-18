package com.qf.service.Impl;

import com.qf.dao.UserDao;
import com.qf.service.UserService;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.Impl
 * @Description:
 * @Date 2022/5/18 12:07
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao =userDao;
    }
    @Override
    public void addUser() {
        userDao.addUser();
    }
}
