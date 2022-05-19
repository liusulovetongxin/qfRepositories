package com.qf.mapper;

import com.qf.pojo.TbUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/19 17:39
 */

public interface UserMapper {

    TbUser findById(@Param("id")Long id);

    void insert(TbUser tbUser);

}
