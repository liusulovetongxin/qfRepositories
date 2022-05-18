package com.qf.test;

import com.qf.service.Impl.UserServiceImpl;
import com.qf.service.LWDJW;
import com.qf.service.UserService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/18 15:21
 */

public class TestProxy {

    @Test
    public void testProxy(){
        UserServiceImpl userService = new UserServiceImpl();
        UserService proxyInstance = (UserService) java.lang.reflect.Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //                        System.err.println("TestProxy类中的invoke方法执行了-->");
                        System.err.println("开启事务");
                        Object result = method.invoke(userService, args);
                        System.err.println("提交事务");
                        return result ;
                    }
                });
        proxyInstance.addUser();
        proxyInstance.updateUser();
        System.out.println();
    }


    @Test
    public void test2(){
        UserService userService = new UserServiceImpl();
        UserService proxy = (UserService) base(userService);
        String s =proxy.addUser();
//        System.err.println(s);
    }

    public Object base(Object object){
        Object proxyInstance =  Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces()
                , new org.springframework.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
//                        System.err.println("TestProxy类中的invoke方法执行了-->");
                        System.err.println("开启事务");
                        Object result = method.invoke(object, args);
                        System.err.println("提交事务");
                        return result+"12312" ;
                    }
                });
        return proxyInstance;
    }

    @Test
    public void test4(){
        LWDJW lwdjw = new LWDJW();
        Enhancer enhancer = new Enhancer();// 创建字节码文件，相当于proxy
        // 之前是设置接口，但是现在没有接口，所以设置父类
        enhancer.setSuperclass(lwdjw.getClass());
        enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            // 参数一样
            // 参数1，正在执行的代理对象
            // 参数2，正在执行代理的方法
            //参数3，代理对象执行的参数
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                System.err.println("冀冀直接筛选");
                if(args!=null&&args[0]!=null &&args[0].toString().startsWith("漂亮")){
                method.invoke(lwdjw, args);
                    System.err.println("冀冀直接很满意");}
                else {
                    System.err.println("冀冀直接很不满意");
                }
                return null;
            }
        });
        LWDJW jw = (LWDJW) enhancer.create();
        jw.add("漂亮小妹妹");
    }
}
