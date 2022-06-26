package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.mapper.SysLogininforMapper;
import com.qf.pojo.SysLogininfor;
import com.qf.service.LoginInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootssm
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/6/14 11:52
 */
@Service
@Transactional
public class LoginInforServiceImpl implements LoginInforService {
    private SysLogininforMapper sysLogininforMapper;

    @Autowired
    public void setSysLogininforMapper(SysLogininforMapper sysLogininforMapper) {
        this.sysLogininforMapper = sysLogininforMapper;
    }

    @Override
    public PageInfo<SysLogininfor> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysLogininfor> list = sysLogininforMapper.findAll();
        PageInfo<SysLogininfor> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
