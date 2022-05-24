package com.qf.service.impl;

import com.qf.constant.ResultCode;
import com.qf.exceptions.AddException;
import com.qf.mapper.UserMapper;
import com.qf.pojo.CheckType;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Administrator
 * @version V1.0
 * @Project MySSMdemo1
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/25 1:17
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void addUser(User user) {
        Assert.isTrue(!user.isEmpty(CheckType.ADD), ()->{
            throw new AddException("添加的数据不完整，请检查后添加", ResultCode.DATE_NULL);
        });
        userMapper.addUser(user);
    }
}
