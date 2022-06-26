package com.qf.mapper;

import com.qf.pojo.SysLogininfor;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootssm
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/6/14 11:59
 */

public interface SysLogininforMapper {
@Select("select * from sys_logininfor")
    List<SysLogininfor> findAll();
}
