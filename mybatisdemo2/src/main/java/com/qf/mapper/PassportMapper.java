package com.qf.mapper;

import com.qf.pojo.TbPassportuser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/16 15:40
 */

public interface PassportMapper {
    TbPassportuser findById(@Param("id")long id);

    void updateById(TbPassportuser tbPassportuser);
}
