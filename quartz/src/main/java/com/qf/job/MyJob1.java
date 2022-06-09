package com.qf.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Administrator
 * @version V1.0
 * @Project quartz
 * @Package com.qf.job
 * @Description:
 * @Date 2022/5/25 11:02
 */

public class MyJob1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("定时任务执行了"+System.currentTimeMillis());
        JobDetail jobDetail =jobExecutionContext.getJobDetail();
        String data = jobDetail.getJobDataMap().getString("key");
        System.err.println(data);

    }
}
