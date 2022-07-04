package com.qf;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version V1.0
 * @Project zookeeperlock
 * @Package com.qf
 * @Description:
 * @Date 2022/7/1 20:03
 */

public class Lock1 {
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
                        countDownLatch.await();
                        lock(framework,null);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
        }
        Thread.sleep(15000);
        countDownLatch.countDown();
        System.in.read();
    }

    public static void lock(CuratorFramework framework,CuratorCache cache){
        try {
            System.err.println("大家都开始了");
            framework.create().withMode(CreateMode.EPHEMERAL).forPath("/testzookeeperlock","数据".getBytes(StandardCharsets.UTF_8));
            System.err.println(Thread.currentThread().getName()+"开始执行自己的业务了");
            Thread.sleep(3000);
            framework.close();
        } catch (Exception e) {
            System.err.println(Thread.currentThread().getName()+"没有抢到锁");
            if (cache==null){
                cache = CuratorCache.builder(framework, "/testzookeeperlock").build();
                CuratorCache finalCache = cache;
                CuratorCacheListener curatorCacheListener = CuratorCacheListener.builder()
                        .forDeletes(childData -> {
                            System.err.println("监听到删除了"+childData.getPath());
                                lock(framework, finalCache);
                        })
                        .build();
                cache.listenable().addListener(curatorCacheListener);
                cache.start();
            }

        }
    }
}
