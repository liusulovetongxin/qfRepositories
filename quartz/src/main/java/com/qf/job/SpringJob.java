package com.qf.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version V1.0
 * @Project quartz
 * @Package com.qf.job
 * @Description:
 * @Date 2022/5/25 11:18
 */
@Component
@EnableScheduling
public class SpringJob {

    @Scheduled(cron = "0/2 * * * * ?")
    public void renwu(){
        System.err.println("spring的定时任务执行了"+System.currentTimeMillis());
    }
}
