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
 * @Date 2022/6/30 20:02
 */

public class ZookeeperBase1 {
    // 阻塞用的，1表示放行一次就可以了
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws Exception {
        // 连接zk
        ZooKeeper zooKeeper = new ZooKeeper(ConnectUtil.SERVER_ADDRESS, 30000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.err.println("ZookeeperBase1类中的process方法执行了-->");
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

        countDownLatch.await();
        System.err.println("=========================分割线");
        String result = zooKeeper.create("/testwatcher",
                "测试数据".getBytes(StandardCharsets.UTF_8),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
//        System.err.println("返回的数据是==》"+result);
        // 父节点不存在的话，子节点也会创建失败
//        String result = zooKeeper.create("/test/test3", "测试数据3".getBytes(StandardCharsets.UTF_8),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                CreateMode.PERSISTENT);
//        System.err.println("返回的数据是==》"+result);
//         获取节点的数据
//        byte[] data = zooKeeper.getData("/testauth", false, null);
//        String result = new String(data);
//        System.err.println("查到的数据是：" + result);
//        List<String> children = zooKeeper.getChildren("/test", false);
//        System.err.println("子节点："+children);

        // 获取所有字节点的数据
//        List<String> childrenList = zooKeeper.getChildren("/test", false);
//        childrenList.forEach(child->{
//            try {
//                String path = "/test/"+child;
//                byte[] data = zooKeeper.getData(path, false, null);
//                System.err.println(path+"节点的数据是==》"+new String(data));
//            } catch (KeeperException e) {
//                throw new RuntimeException(e);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

//        Stat stat = zooKeeper.exists("/test", false);
//        System.err.println(stat);
//        int version = stat.getVersion();
//        zooKeeper.setData("/test", "新的数据+1".getBytes(StandardCharsets.UTF_8), version);
//


//        zooKeeper.delete("/test", -1);
//        List<String> children = zooKeeper.getChildren("/test", false);
//        children.forEach(child->{
//            String path = "/test/"+child;
//            try {
//                zooKeeper.delete(path, -1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } catch (KeeperException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        zooKeeper.delete("/test", -1);

        System.err.println("方法执行完毕");
        zooKeeper.close();
    }
}
