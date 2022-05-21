package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project ssmtest
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/21 17:24
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<TbUser> findAll() {
        return  userMapper.findAll();
    }
}
