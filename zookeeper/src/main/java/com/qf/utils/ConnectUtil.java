package com.qf.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author Administrator
 * @version V1.0
 * @Project zookeeper
 * @Package com.qf.utils
 * @Description:
 * @Date 2022/6/30 19:48
 */

public class ConnectUtil {
    public static final String SERVER_ADDRESS = "10.9.48.182:2181";

    public static CuratorFramework getFramework() {
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder()
                        .connectString(SERVER_ADDRESS)
                        .connectionTimeoutMs(30000)
                        .sessionTimeoutMs(60000)
                        .retryPolicy(new ExponentialBackoffRetry(
                                1000, 5
                        )).build();
        curatorFramework.start();
        return curatorFramework;
    }
}
