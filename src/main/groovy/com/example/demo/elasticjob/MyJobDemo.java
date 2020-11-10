package com.example.demo.elasticjob;

import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @author luojian
 * @version 1.0
 * @date 2020年11月06日 18:41
 */
public class MyJobDemo {
    /*public static void main(String[] args) {
        new ScheduleJobBootstrap(createRegistryCenter(), new MyJob(), createJobConfiguration()).schedule();
    }
    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("127.0.0.1:2181", "my-job"));
        regCenter.init();
        return regCenter;
    }*/

    public static void main(String[] args) {
        // 调度基于 class 类型的作业
        new ScheduleJobBootstrap(createRegistryCenter(), new MyJob(), createJobConfiguration()).schedule();
        // 调度基于 type 类型的作业
//        new ScheduleJobBootstrap(createRegistryCenter(), "MY_TYPE", createJobConfiguration()).schedule();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        ZookeeperConfiguration zkConfig = new ZookeeperConfiguration("127.0.0.1:2181", "elastic-job-demo");
        zkConfig.setSessionTimeoutMilliseconds(10000);
        zkConfig.setConnectionTimeoutMilliseconds(3000);
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(zkConfig);
        regCenter.init();
        return regCenter;
    }


    private static JobConfiguration createJobConfiguration() { // 创建作业配置 // ...
        return JobConfiguration.newBuilder("myJob", 3).cron("1/30 * * * * ? ").overwrite(true).shardingItemParameters("0=Beijing,1=Shanghai,2=Guangzhou").build();

    }
}
