package com.example.demo.elasticjob.listener;

import org.apache.shardingsphere.elasticjob.infra.listener.ShardingContexts;
import org.apache.shardingsphere.elasticjob.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import org.springframework.stereotype.Component;

/**
 * @author luojian
 * @version 1.0
 * @date 2020年11月11日 17:26
 */
public class MyDistributeOnceJobListener extends AbstractDistributeOnceElasticJobListener {
    private static final long STARTED_TIMEOUT_MILLISECONDS = 5000L;
    private static final long COMPLETED_TIMEOUT_MILLISECONDS = 5000L;

    public MyDistributeOnceJobListener() {
        super(STARTED_TIMEOUT_MILLISECONDS, COMPLETED_TIMEOUT_MILLISECONDS);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        // do something ...
        System.out.println("doBeforeJobExecutedAtLastStarted - do something ...");
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        // do something ...
        System.out.println("doAfterJobExecutedAtLastCompleted - do something ...");
    }

    @Override
    public String getType() {
        return "myDistributeOnceJobListener";
    }
}
