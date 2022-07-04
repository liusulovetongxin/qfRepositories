package com.qf.zookeeper;

import com.qf.utils.ConnectUtil;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version V1.0
 * @Project zookeeper
 * @Package com.qf
 * @Description:
 * @Date 2022/6/30 20:51
 */

public class ServiceClient1 implements Watcher {
    private static ZooKeeper zooKeeper;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.err.println("ZookeeperWatcher类中的process方法执行了-->");
        Event.EventType type = watchedEvent.getType();
        Event.KeeperState state = watchedEvent.getState();
        String path = watchedEvent.getPath();
        if (state==Event.KeeperState.SyncConnected){
            switch (type){
                case None:
                    System.err.println("连接成功");
                    break;

            }
        }
        countDownLatch.countDown();
    }
    public static void main(String[] args) throws Exception {
        ServiceClient1 zw = new ServiceClient1();
        zooKeeper = new ZooKeeper(ConnectUtil.SERVER_ADDRESS, 30000, zw);
        countDownLatch.await();

        Stat exists = zooKeeper.exists("/02FASKFAS", true);
        if (exists==null){
            zooKeeper.create( "/02FASKFAS","父节点".getBytes(StandardCharsets.UTF_8),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);
        }

        zooKeeper.create("/02FASKFAS/192.168.1.2:11001", "我的地址".getBytes(StandardCharsets.UTF_8),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL);

        System.in.read();
        zooKeeper.close();
        System.err.println("程序运行结束");
    }
}
