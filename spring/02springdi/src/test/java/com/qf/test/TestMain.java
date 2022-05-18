package com.qf.test;

import com.qf.dao.Impl.UserDaoImpl;
import com.qf.pojo.*;
import com.qf.service.Impl.UserServiceImpl;
import com.qf.service.UserService;
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
    @Test
    public void test1(){
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
        userService.addUser();
    }

    @Test
    public void test2(){
        UserService userService = context.getBean(UserService.class);
        userService.addUser();
    }
    @Test
    public void test3(){
        Order order = new Order();
        Item item = new Item();
        item.setName("不知道什么玩意");
        City city = new City();
        city.setCityName("北京");
        Address address = new Address();
        address.setCity(city);
        order.setItem(item);
        order.setAddress(address);
    }
    @Test
    public void test4(){
        Order order = context.getBean(Order.class);
        System.err.println(order.toString());
    }
    @Test
    public void test5() {
        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean(User.class);
        System.err.println(user);
    }

    @Test
    public void test6() {
        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);
        Person person3 = context.getBean(Person.class);
    }
}
