package com.personal.cloud.demo.service.demo.impl;

import com.google.common.collect.Lists;
import com.personal.cloud.demo.dao.DemoEntityDto;
import com.personal.cloud.demo.service.demo.IDemoCallableService;
import com.personal.cloud.demo.service.thread.demo.DemoCallable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2019-09-29.
 */
@Service
@Transactional
public class DemoCallableServiceImpl implements IDemoCallableService {

    private static final Logger logger = LoggerFactory.getLogger(DemoCallableServiceImpl.class);

    @Override
    public List<DemoEntityDto> list(String name, String type) {
        List<DemoEntityDto> resultList = Lists.newArrayList();
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            DemoCallable demoCallable = new DemoCallable();
            demoCallable.type = type;
            demoCallable.name = name;
            FutureTask<List<DemoEntityDto>> future = new FutureTask<>(demoCallable);
            executor.execute(future);
//            resultList =  future.get(500, TimeUnit.MICROSECONDS);
            resultList =  future.get();
        } catch (Exception e) {
            logger.error(this.getClass().getSimpleName(),e.getMessage());
            Assert.isTrue(false,"查询失败！");
        }
        return resultList;
    }
}
