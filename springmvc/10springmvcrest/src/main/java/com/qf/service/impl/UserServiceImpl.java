package com.qf.service.impl;

import com.qf.pojo.User;
import com.qf.service.UserService;

import java.util.Date;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/23 21:07
 */

public class UserServiceImpl implements UserService {
    @Override
    public User findByName(String name) {
        User user = new User();
        user.setUserName(name);
        user.setAge(30);
        user.setGender("男");
        user.setBirthday(new Date());
        return user;
    }
}
