package com.personal.cloud.demo.service.thread.demo;

import com.personal.cloud.demo.dao.DemoEntityDto;
import com.personal.cloud.demo.service.demo.IMongodbDemoService;
import com.personal.cloud.demo.tool.SpringContextHolder;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2019-09-29.
 */
public class DemoCallable implements Callable<List<DemoEntityDto>> {

    public String type;

    public String name;

    IMongodbDemoService mongodbDemoService = SpringContextHolder.getBean("mongodbDemoService");

    @Override
    public List<DemoEntityDto> call() throws Exception {
        return mongodbDemoService.list(name,type);
    }
}
