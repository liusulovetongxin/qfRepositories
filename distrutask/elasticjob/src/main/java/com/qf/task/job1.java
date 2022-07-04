package com.qf.task;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version V1.0
 * @Project elasticjob
 * @Package com.qf.task
 * @Description:
 * @Date 2022/7/1 21:01
 */

@Component
public class job1 implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        int totalCount = shardingContext.getShardingTotalCount();
        int shardingItem = shardingContext.getShardingItem();
        String shardingParameter = shardingContext.getShardingParameter();

        switch (shardingParameter){
            case "caoxian":
                System.err.println("山东菏泽曹县，牛啤，666，我嘞宝贝");
                break;
            case "gansu":
                System.err.println("甘肃不大，创造神话");
                break;
            case "chenyihan":
                System.err.println("不是，这都拿不下你？");
                break;
            case "goubao":
                System.err.println("有点东西，但东西不多");
                break;
        }

    }
}
