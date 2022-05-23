package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/23 23:04
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public TbUser findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void addUser(TbUser tbUser) {
        userMapper.addUser(tbUser);
        int i = 1 / 0;
    }
}
