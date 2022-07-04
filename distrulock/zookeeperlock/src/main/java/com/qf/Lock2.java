package com.qf;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version V1.0
 * @Project zookeeperlock
 * @Package com.qf
 * @Description:
 * @Date 2022/7/1 20:03
 */

public class Lock2 {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    CuratorFramework framework = CuratorFrameworkFactory.builder()
                            .connectString("10.9.12.200:9096")
                            .sessionTimeoutMs(60000)
                            .connectionTimeoutMs(60000)
                            .retryPolicy(new ExponentialBackoffRetry(
                                    1000, 5)).build();

                    framework.start();
                    System.err.println(Thread.currentThread().getName()+"等待中");
                    try {
                        InterProcessMutex processMutex = new InterProcessMutex(framework, "/testfenbushisuo");

                        countDownLatch.await();
                        processMutex.acquire();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ssss");
                        String s = format.format(new Date());
                        System.err.println(Thread.currentThread().getName()+"执行操作了，时间是："+s);
                        Thread.sleep(1000);
                        processMutex.release();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
        }
        Thread.sleep(10000);
        countDownLatch.countDown();
        System.in.read();
    }
}
