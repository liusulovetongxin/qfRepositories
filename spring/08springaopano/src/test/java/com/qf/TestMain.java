package com.qf;

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
 * @Date 2022/5/19 10:43
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
        userService.addUser();
    }

    @Test
    public void test2(){
        UserService userService = context.getBean(UserService.class);
        String s =userService.updateUser();
        System.err.println(s);
    }
}
