package com.qf;

import com.qf.job.MyJob1;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Administrator
 * @version V1.0
 * @Project quartz
 * @Package com.qf
 * @Description:
 * @Date 2022/5/25 11:06
 */

public class TestQuartz {

    @Test
    public void test1() throws IOException, SchedulerException {
        // 获取需要定时的任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
                .usingJobData("key", "数据")
                .withIdentity("renwu1", "group1")
                .build();
        // 设置触发器
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .withRepeatCount(20))
                .build();

        // 调度器，整合到一块
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();
        System.in.read();
    }

    @Test
    public void test2() throws IOException, SchedulerException {
        // 获取需要定时的任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
                .usingJobData("key", "数据")
                .withIdentity("renwu1", "group1")
                .build();
        // 设置触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();

        // 调度器，整合到一块
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
        System.in.read();
    }

    @Test
    public void test3() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.in.read();
    }

    @Test
    public void test4() throws Exception {
        // 获取任务
        JobDetail jobDetail = JobBuilder
                .newJob(MyJob1.class)
                .withIdentity("name1", "group1")
                .usingJobData("key", "测试数据").build();
        // 获取数据
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(1)
                                .withRepeatCount(10)
                ).build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();
        System.in.read();
    }


    @Test
    public void test5() throws Exception {
        Logger logger = LoggerFactory.getLogger(MyJob1.class);
        logger.trace("这是trace");
        JobDetail jobDetail = JobBuilder
                .newJob(MyJob1.class)
                .usingJobData("key", "测试cron数据")
                .withIdentity("name1", "group1")
                .build();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(
                        CronScheduleBuilder
                                .cronSchedule("0/1 * * * * ?")
                ).build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
        System.in.read();
    }

}
