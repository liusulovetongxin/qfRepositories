package com.qf.service.impl;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/21 0:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findByName(String name) {
        User user = new User();
        user.setUsername(name);
        user.setPassword("123");
        user.setAge(21);
        user.setGender("男");
        user.setBrithday(new Date());
        return user;
    }
}
