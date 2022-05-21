package com.qf.test;

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
 * @Project ssmtest
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/21 17:25
 */

public class TestMain {
    private ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void test1(){
        UserService userService = context.getBean(UserService.class);
        List<TbUser> list = userService.findAll();
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }
    }

}
