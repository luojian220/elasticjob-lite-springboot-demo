package com.example.demo.elasticjob.job;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * @author luojian
 * @version 1.0
 * @date 2020年11月06日 18:36
 */
@Component
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        System.out.println(String.format("开始执行任务---%s ,%s , %s ,",context.getJobName(),context.getShardingItem(),context.getShardingParameter()));
        switch (context.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                break;
            case 1:
                // do something by sharding item 1
                break;
            case 2:
                // do something by sharding item 2
                break;
            // case n: ...

        }
    }
}