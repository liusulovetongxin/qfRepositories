package com.qf.curator;

import com.qf.utils.ConnectUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project zookeeper
 * @Package com.qf.curator
 * @Description:
 * @Date 2022/7/1 08:33
 */

public class CuratorBase {
    public static void main(String[] args) throws Exception {
//       createPath();
//        createPathWithParent();
//        setData();
//        getData();
//        getChildren();
        delete();
    }
    public static void delete()throws Exception{
        CuratorFramework framework = ConnectUtil.getFramework();
        framework.delete().deletingChildrenIfNeeded()
                .forPath("/testcurator");
    }


    public static void getChildren()throws Exception{
        CuratorFramework framework = ConnectUtil.getFramework();
        List<String> list = framework.getChildren().forPath("/testcurator");
        list.forEach(System.err::println);
    }


    public static void setData()throws Exception{
        CuratorFramework framework = ConnectUtil.getFramework();
        framework.setData().forPath("/testcurator", "测试修改的数据".getBytes(StandardCharsets.UTF_8));
    }

    public static void getData()throws Exception{
        CuratorFramework framework = ConnectUtil.getFramework();
        byte[] bytes = framework.getData().forPath("/testcurator");
        System.err.println("获取到的节点数据是："+new String(bytes));
    }


    public static void createPathWithParent()throws Exception{
        CuratorFramework framework = ConnectUtil.getFramework();
        framework.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/testcurator/a/b","测试curator的数据".getBytes(StandardCharsets.UTF_8));

    }
    public static void createPath()throws Exception{
        CuratorFramework framework = ConnectUtil.getFramework();
        framework.create()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/testcurator","测试curator的数据".getBytes(StandardCharsets.UTF_8));

    }
}
