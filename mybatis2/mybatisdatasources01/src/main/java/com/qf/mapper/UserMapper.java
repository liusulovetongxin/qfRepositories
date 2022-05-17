package com.qf.mapper;

import com.qf.pojo.TbUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatis2
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/17 12:31
 */

public interface UserMapper {
    TbUser findById(@Param("id") Long id);

}
