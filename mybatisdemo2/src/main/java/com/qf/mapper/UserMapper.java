package com.qf.mapper;

import com.qf.pojo.TUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/16 9:50
 */

public interface UserMapper {
    List<TUsers> findAll();

    TUsers findById(Long id);

    TUsers findByUserNameAndPasswordWithMap(Map map);

    TUsers findByUnameAndPasswordWithPojo(TUsers tUsers);

    TUsers findByUnameAndPassword(@Param("name")String name,@Param("password")String password);

    List<TUsers> findByNameLike(@Param("likeName")String likeName);
    List<TUsers> findBySexLike(@Param("likeSex")String likeSex);

}
