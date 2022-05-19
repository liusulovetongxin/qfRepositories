package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/19 15:36
 */

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public TbUser findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void addUser(TbUser tbUser) {
        userMapper.addUser(tbUser);

    }
}
