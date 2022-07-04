package com.qf;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version V1.0
 * @Project redislock1
 * @Package com.qf
 * @Description:
 * @Date 2022/7/1 19:24
 */

public class RedisLockTest1 {
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    @Test
    public void testLock1() throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    Jedis jedis = new Jedis("10.9.12.200",9081);
                    jedis.auth("redis001");
                    try {
                        countDownLatch.await();

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        lock(jedis);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
        }
        Thread.sleep(5000);
        countDownLatch.countDown();
        System.in.read();
    }


    public  void lock(Jedis jedis)throws Exception{
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SetParams setParams = SetParams.setParams().px(1500).nx();
        String setnx = jedis.set("testredislock", "测试redis锁", setParams);
//        long setnx = jedis.setnx("testredislock", "测试redis锁");
//        jedis.pexpire("testredislock", 1500);
//                    System.err.println(Thread.currentThread().getName()+"==>值为==>"+setnx);
        if (setnx!=null){
            System.err.println(Thread.currentThread().getName()+"开始执行业务");
            Thread.sleep(1000);
            jedis.del("testredislock");
        }else{
            System.err.println(Thread.currentThread().getName()+"没有抢到");
            Thread.sleep(2000);
            lock(jedis);
        }
    }
}
