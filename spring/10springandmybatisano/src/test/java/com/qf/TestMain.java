package com.qf;

import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf
 * @Description:
 * @Date 2022/5/19 20:11
 */

public class TestMain {
    private ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test1(){
        UserService userService = context.getBean(UserService.class);
        TbUser user = userService.findById(1L);
        System.err.println(user);
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
