package com.qf.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatis2
 * @Package com.qf.uitls
 * @Description:
 * @Date 2022/5/17 12:22
 */

public class MyDruidDatasourceFactory extends PooledDataSourceFactory {

    public MyDruidDatasourceFactory() {

        this.dataSource = new DruidDataSource();
    }
}
