package com.personal.cloud.controller.demo;

import com.google.common.collect.Lists;
import com.personal.cloud.demo.domain.DemoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2019-08-21.
 */
public class test {

    private static final Logger logger = LoggerFactory.getLogger(test.class);

    public static void main(String[] args) {

        Long startDate = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<List<DemoEntity>> future = new FutureTask<>(new Callable<List<DemoEntity>>() {
            public List<DemoEntity> call() throws Exception {
                List<DemoEntity> resultList = Lists.newArrayList();
                DemoEntity entity = new DemoEntity();
                entity.setCode("TEST001");
                entity.setNum(100);
                entity.setName("测试1");
                entity.setDescription("future 测试1");
                resultList.add(entity);
                return resultList;
            }
        });

        FutureTask<List<DemoEntity>> future2 = new FutureTask<List<DemoEntity>>(new Callable<List<DemoEntity>>() {
            public List<DemoEntity> call() throws Exception {
                List<DemoEntity> resultList = Lists.newArrayList();
                DemoEntity entity = new DemoEntity();
                entity.setCode("TEST002");
                entity.setNum(99);
                entity.setName("测试2");
                entity.setDescription("future 测试2");
                resultList.add(entity);
                Thread.sleep(1000);
                return resultList;
            }
        });

        executor.execute(future);
        executor.execute(future2);
        List<DemoEntity> resultList = Lists.newArrayList();
        try {

            List<DemoEntity> resultList1 =  future.get(500,TimeUnit.MICROSECONDS);
            List<DemoEntity> resultList2 =  future.get(500,TimeUnit.MICROSECONDS);
            resultList.addAll(resultList1);
            resultList.addAll(resultList2);
        } catch (InterruptedException e) {
            logger.error("当前线程在等待时中断");
            future.cancel(true);
        } catch (ExecutionException e) {
            logger.error("计算引发异常");
            future.cancel(true);
        } catch (TimeoutException e) {
            logger.error("等待超时");
            future.cancel(true);
        } catch (CancellationException e){
            logger.error("计算被取消");
        }finally {
            executor.shutdown();
        }

        Long endDate = System.currentTimeMillis();

    }


}
