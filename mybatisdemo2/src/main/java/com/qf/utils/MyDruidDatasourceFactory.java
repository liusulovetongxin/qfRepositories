package com.qf.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.utils
 * @Description:
 * @Date 2022/5/16 11:51
 */

public class MyDruidDatasourceFactory extends PooledDataSourceFactory {
    public MyDruidDatasourceFactory(){
        this.dataSource = new DruidDataSource();
    }
}
