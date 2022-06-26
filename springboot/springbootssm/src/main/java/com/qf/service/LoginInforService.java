package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.SysLogininfor;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootssm
 * @Package com.qf.service
 * @Description:
 * @Date 2022/6/14 11:51
 */

public interface LoginInforService {
    PageInfo<SysLogininfor> findAll(int pageNum, int pageSize);
}
