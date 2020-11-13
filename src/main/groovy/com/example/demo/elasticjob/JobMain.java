package com.example.demo.elasticjob;

import com.example.demo.elasticjob.job.MyJob;
import com.example.demo.elasticjob.listener.MyJobListener;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @author luojian
 * @version 1.0
 * @date 2020年11月11日 17:29
 */
public class JobMain{

    public static void main(String[] args) {
        MyJobListener myJobListener = new MyJobListener();
        new ScheduleJobBootstrap(createRegistryCenter(), new MyJob(), createJobConfiguration()).schedule();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("localhost:2181", "elasticjob-lite-springboot"));
        regCenter.init();
        return regCenter;
    }

    private static JobConfiguration createJobConfiguration() {
        return JobConfiguration
                .newBuilder("myJob", 3)
                .cron("1/30 * * * * ? ")
                .overwrite(true)
                .shardingItemParameters("0=Beijing,1=Shanghai,2=Guangzhou")
                .jobListenerTypes("mySimpleJobListener", "myDistributeOnceJobListener")
                .build();

    }
}
