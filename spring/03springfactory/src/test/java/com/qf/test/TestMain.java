package com.qf.test;

import com.qf.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/18 12:23
 */

public class TestMain {
    private ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @After
    public void after(){
        ((ClassPathXmlApplicationContext)context).close();
    }
    @Test
    public void test() {
        UserService userService = context.getBean(UserService.class);
         userService.addUser();
    }


}
