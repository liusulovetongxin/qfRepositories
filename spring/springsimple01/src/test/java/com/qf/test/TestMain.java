package com.qf.test;

import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/17 16:28
 */

public class TestMain {
    @Test
    public void test1(){
        UserService userService = new UserServiceImpl();
        userService.addUser("张三");
    }
    @Test
    public void test2(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("UserService");
        userService.addUser("123");
    }
}
