package com.personal.cloud.demo.service.demo;

import com.personal.cloud.demo.dao.DemoEntityDto;
import com.personal.cloud.demo.domain.DemoEntity;

import java.util.List;

/**
 * Created by Administrator on 2019-07-30.
 */
public interface IMongodbDemoService {

    DemoEntity save(DemoEntity demoEntity);

    void delete(String id);

    List<DemoEntityDto> list(String name, String type);
}
