package com.qf.test;

import com.github.pagehelper.PageHelper;
import com.qf.mapper.UserMapper;
import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/19 15:11
 */

public class TestMain {
    private ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test1(){
        UserMapper userMapper = context.getBean(UserMapper.class);
        TbUser user = userMapper.findById(1L);
        System.err.println(user.toString());
    }

    @Test
    public void test2(){
        UserMapper userMapper = context.getBean(UserMapper.class);
        List<TbUser> list = userMapper.findAll();
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }

    }

    @Test
    public void test3(){
        UserMapper userMapper = context.getBean(UserMapper.class);
        PageHelper.startPage(1,5);
        List<TbUser> list = userMapper.findAll();
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }
    }

    @Test
    public void test5(){
        UserMapper userMapper = context.getBean(UserMapper.class);
//        PageHelper.startPage(1,5);
        List<TbUser> list = userMapper.findByLikeName("zhang");
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }
    }
    @Test
    public void test6(){
        UserService userService = context.getBean(UserService.class);
        TbUser tbUser = new TbUser();
        tbUser.setUsername("admin123123");
        tbUser.setPassword("admin123123");
        tbUser.setEmail("admin123123@qq.com");
        tbUser.setGender("男");
        tbUser.setFlag(1L);
        tbUser.setRole(1L);
        tbUser.setCode("code");
        userService.addUser(tbUser);

    }
}
