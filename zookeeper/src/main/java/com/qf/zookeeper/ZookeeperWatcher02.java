package com.qf.zookeeper;

import com.qf.utils.ConnectUtil;
import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version V1.0
 * @Project zookeeper
 * @Package com.qf
 * @Description:
 * @Date 2022/6/30 20:51
 */

public class ZookeeperWatcher02 implements Watcher {
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
                case NodeCreated:
                    System.err.println(path + "创建成功");
                    try {
                        byte[] data = zooKeeper.getData(path, true, null);
                        System.err.println("当前创建的节点数据是"+new String(data));
                    } catch (KeeperException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case NodeDataChanged:
                    System.err.println(path+"数据更新成功");
                    try {
                        byte[] data2 = zooKeeper.getData(path, true, null);
                        System.err.println("更新的数据是"+new String(data2));
                    } catch (KeeperException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case NodeChildrenChanged:
                    try {
                        List<String> children = zooKeeper.getChildren(path, true);
                        children.forEach(System.err::println);
                    } catch (KeeperException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
        countDownLatch.countDown();
    }
    public static void main(String[] args) throws Exception {
        ZookeeperWatcher02 zw = new ZookeeperWatcher02();
        zooKeeper = new ZooKeeper(ConnectUtil.SERVER_ADDRESS, 30000, zw);
        countDownLatch.await();
//        zooKeeper.exists("/01FASJFLAKSFNFJKLSAJ", true);
//        zw.createChildren("测试孩子数据", "/01FASJFLAKSFNFJKLSAJ/192.168.1.1:10003");
        zw.deletePath("/01FASJFLAKSFNFJKLSAJ/192.168.1.1:10003");
        System.in.read();
        System.err.println("程序运行结束");
    }

    public void createPath(String data,String path) throws Exception{
        zooKeeper.exists(path, true);
        zooKeeper.create(path, data.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
    }


    public String readData(String path,boolean needWatcher)throws Exception{
        byte[] data = zooKeeper.getData(path, needWatcher, null);
        return new String(data);
    }
    public void writerData(String path,String data)throws Exception{
        zooKeeper.setData(path, data.getBytes(StandardCharsets.UTF_8), -1);
    }
    public void createChildren(String data,String children) throws Exception{
        zooKeeper.exists(children, true);
        zooKeeper.create(children, data.getBytes(StandardCharsets.UTF_8),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
    }

    public List<String> getChildren(String children, boolean needWatcher)throws Exception{
        return zooKeeper.getChildren(children, needWatcher);
    }
    public void deletePath(String path)throws Exception{
        zooKeeper.delete(path, -1);
    }

}
