package com.qf.event;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.event
 * @Description:
 * @Date 2022/5/23 12:48
 */

public class TestMain {
    private ApplicationContext context;

    @Before
    public void before() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test1(){
        FireWarning fireWarning = new FireWarning();
        fireWarning.setAddress("jgss");
        context.publishEvent(fireWarning);
    }

}
