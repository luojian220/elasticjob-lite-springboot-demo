package com.example.demo.elasticjob;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;

/**
 * @author luojian
 * @version 1.0
 * @date 2020年11月06日 18:36
 */
public class MyJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                System.out.println("o something by sharding item 0");
                break;
            case 1:
                // do something by sharding item 1
                System.out.println("o something by sharding item 1");
                break;
            case 2:
                // do something by sharding item 2
                System.out.println("o something by sharding item 2");
                break;
            // case n: ...
        }

    }

    }