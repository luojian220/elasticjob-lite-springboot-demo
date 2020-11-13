package com.example.demo.elasticjob.job;

import com.example.demo.elasticjob.model.Foo;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.dataflow.job.DataflowJob;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luojian
 * @version 1.0
 * @date 2020年11月10日 17:16
 */
@Component
public class SpringBootDataflowJob implements DataflowJob<Foo> {
    private static AtomicInteger count = new AtomicInteger(0);
    @Override
    public List<Foo> fetchData(final ShardingContext shardingContext) {
        // 获取数据 模拟从数据库 获取数据
        String name = "第" + shardingContext.getShardingItem() +"-"+count.incrementAndGet() + "页数据";
        System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS")+ "------" + "获取数据" + + shardingContext.getShardingItem() +"  ;  "+ shardingContext.getShardingParameter() + "---" + name );
        List<Foo> list = new ArrayList<>();
        Foo foo = new Foo();
        foo.setName(name);
        list.add(foo);

        try {
            Random random = new Random();
            int millis = 200 * random.nextInt(5);
            System.out.println(millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void processData(final ShardingContext shardingContext, final List<Foo> data) {
        // 处理数据
        System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS") + "------" + "处理数据 " + shardingContext.getShardingItem() +"  ;  "+ shardingContext.getShardingParameter() +"  ;  "+  data.iterator().next());
    }
}
