package com.qf.test;

import com.qf.service.Impl.UserServiceImpl2;
import com.qf.service.SZZYHJW;
import com.qf.service.UserService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/18 20:40
 */

public class TestMyProxy {
    @Test
    public void TestMyProxy(){
        UserService userService = new UserServiceImpl2();
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.err.println("模拟进行开启事务操作");
                        String result = (String) method.invoke(userService, args);
                        System.err.println("模拟进行提交事务操作");
                        return result + "123";
                    }
                });
        String s =proxyInstance.addUser();
        System.err.println(s);
    }
    @Test
    public void MyEnhancer() {
        SZZYHJW szzyhjw = new SZZYHJW();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(szzyhjw.getClass());
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                String s = "书中自有黄金屋";
                method.invoke(szzyhjw, s);
                return null;
            }
        });
        SZZYHJW sz = (SZZYHJW) enhancer.create();
        sz.StringAppend("123");

    }
}
