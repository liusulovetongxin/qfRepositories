package com.qf.mapper;

import com.qf.pojo.TbUser;
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
    List<TbUser> findAll();

    TbUser findById(Long id);

    TbUser findByUserNameAndPasswordWithMap(Map map);

    TbUser findByUnameAndPasswordWithPojo(TbUser tUsers);

    TbUser findByUnameAndPassword(@Param("username")String username,@Param("password")String password);

    List<TbUser> findByNameLike(@Param("likeName")String likeName);
    List<TbUser> findBySexLike(@Param("likeSex")String likeSex);
    TbUser findWithOrderByUid(@Param("uid")long uid);
    List<TbUser> findByMulti(Map map);
    List<TbUser> findByIds(@Param("ids") List<Long> ids);
}
