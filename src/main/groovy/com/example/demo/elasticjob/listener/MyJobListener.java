package com.example.demo.elasticjob.listener;

import org.apache.shardingsphere.elasticjob.infra.listener.ElasticJobListener;
import org.apache.shardingsphere.elasticjob.infra.listener.ShardingContexts;

/**
 * @author luojian
 * @version 1.0
 * @date 2020年11月11日 17:26
 */
public class MyJobListener implements ElasticJobListener {

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        // do something ...
        System.out.println("beforeJobExecuted - do something ...");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        // do something ...
        System.out.println("afterJobExecuted - do something ...");
    }

    @Override
    public String getType() {
        return "mySimpleJobListener";
    }
}