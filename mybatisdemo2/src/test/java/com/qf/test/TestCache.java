package com.qf.test;

import com.qf.mapper.UserMapper;
import com.qf.pojo.TbUser;
import com.qf.utils.MyBatisUtil;
import org.junit.Test;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/16 17:08
 */

public class TestCache {
    @Test
    public void testCache(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        TbUser user = userMapper.findById(1L);
        System.err.println("第一次缓存");
        System.err.println(user.toString());
        TbUser user1 = userMapper.findById(1L);
        System.err.println("第二次缓存");
        System.err.println(user1.toString());
        MyBatisUtil.closeAll();
        UserMapper userMapper1 = MyBatisUtil.getMapper(UserMapper.class);
        TbUser user2 = userMapper1.findById(1L);
        System.err.println("第三次缓存");
        System.err.println(user2.toString());
    }
}
