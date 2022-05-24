package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.constans.ResultCode;
import com.qf.exceptions.AddDataException;
import com.qf.exceptions.QueryException;
import com.qf.exceptions.UpdataException;
import com.qf.mapper.TUserMapper;
import com.qf.pojo.CheckType;
import com.qf.pojo.TbUser;
import com.qf.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/5/24 19:36
 */
@Service
@Transactional
public class TUserServiceImpl implements TUserService {
    private TUserMapper tUserMapper;

    @Autowired
    public void settUserMapper(TUserMapper tUserMapper) {
        this.tUserMapper = tUserMapper;
    }

    @Override
    public void addUser(TbUser tbUser) {
        Assert.isTrue(!tbUser.isEmpty(CheckType.ADD),()->{
            throw new AddDataException("没有传输必要数据", ResultCode.DATA_NULL);
        });

        tUserMapper.addUser(tbUser);
    }

    @Override
    public int updateUser(TbUser tbUser) {
        Assert.isTrue(!tbUser.isEmpty(CheckType.UPDATE), ()->{
            throw new UpdataException("数据有误",ResultCode.DATA_NULL);
        });
        return tUserMapper.updateUser(tbUser);
    }

    @Override
    public PageInfo<TbUser> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbUser> userList = tUserMapper.findAll();
        PageInfo<TbUser> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public TbUser findById(Long id) {
        Assert.isTrue(id>0, ()->{
            throw new QueryException("id不能为负数",ResultCode.ID_NOTALLOWED);
        });
        TbUser tb = tUserMapper.findById(id);
        tb.setPassword(null);
        return tb;
    }

    @Override
    public TbUser findByUserName(TbUser user) {
        Assert.hasText(user.getUsername(), ()->{
            throw new QueryException("用户名密码不能为空", ResultCode.USERNAME_PASSWORD_NULL);
        });
        TbUser tbUser = tUserMapper.findByUserName(user.getUsername());
        Assert.isTrue(tbUser!=null&&tbUser.getPassword().equals(user.getPassword()), ()->{
            throw new QueryException("用户名密码错误", ResultCode.USERNAME_PASSWORD_ERROR);
        });
        tbUser.setPassword(null);
        return tbUser;
    }

}
