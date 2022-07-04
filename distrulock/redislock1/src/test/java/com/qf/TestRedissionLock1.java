package com.qf;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version V1.0
 * @Project redislock1
 * @Package com.qf
 * @Description:
 * @Date 2022/7/1 19:50
 */

public class TestRedissionLock1 {
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    @Test
    public void testLock1()throws Exception{
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    Config config = new Config();
                    config.useSingleServer()
                                    .setAddress("redis://10.9.12.200:9081")
                                            .setPassword("redis001");
                    //创建一个客户端
                    RedissonClient client = Redisson.create(config);
                    // 创建一把锁，nx类型操作
                    RLock rLock = client.getLock("testredissionlock");
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    rLock.lock();
                    System.err.println(Thread.currentThread().getName()+"抢到锁了");
                    try {
                        Thread.sleep(new Random().nextInt(3000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    rLock.unlock();
                }
            }.start();
        }
        Thread.sleep(5000);
        countDownLatch.countDown();
        System.in.read();

    }
}
