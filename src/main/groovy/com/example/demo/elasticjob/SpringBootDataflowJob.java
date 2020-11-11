package com.example.demo.elasticjob;

import com.example.demo.elasticjob.model.Foo;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.dataflow.job.DataflowJob;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
        System.out.println(System.currentTimeMillis() + "获取数据" + + shardingContext.getShardingItem() +"  ;  "+ shardingContext.getShardingParameter() );
        if (count.incrementAndGet() > 5) {
            return null;
        }
        List<Foo> list = new ArrayList<>();
        Foo foo = new Foo();
        foo.setName(" name " + shardingContext.getShardingParameter());
        list.add(foo);

        if (count.get() % 3 == 0) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void processData(final ShardingContext shardingContext, final List<Foo> data) {
        // 处理数据
        System.out.println(System.currentTimeMillis() + "处理数据 " + shardingContext.getShardingItem() +"  ;  "+ shardingContext.getShardingParameter() +"  ;  "+  data.iterator().next());
    }
}
