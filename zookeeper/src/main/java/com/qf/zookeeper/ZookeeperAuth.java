package com.qf.zookeeper;

import com.qf.utils.ConnectUtil;
import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version V1.0
 * @Project zookeeper
 * @Package com.qf
 * @Description:
 * @Date 2022/6/30 20:38
 */

public class ZookeeperAuth {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static final String AUTHENTICATION_TYPE = "digest";
    private static final String CORRECTAUTHENTICATION = "123456";

    public static void main(String[] args)throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(ConnectUtil.SERVER_ADDRESS, 30000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.err.println("ZookeeperAuth类中的process方法执行了-->");
                Event.KeeperState state = watchedEvent.getState();
                Event.EventType type = watchedEvent.getType();
                if (state == Event.KeeperState.SyncConnected){
                    if (type== Event.EventType.None){
                        System.err.println("连接成功");
                    }
                }
                countDownLatch.countDown();
            }
        });
        zooKeeper.addAuthInfo(AUTHENTICATION_TYPE,CORRECTAUTHENTICATION.getBytes());
        countDownLatch.await();
        String result = zooKeeper.create("/testauth", "权限测试数据".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        System.err.println(result);
        System.err.println("=========================分割线");
        zooKeeper.close();
        }
}
