package com.personal.cloud.demo.dao;

import com.personal.cloud.demo.domain.DemoEntity;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

/**
 * Created by Administrator on 2019-07-30.
 */
public interface IMongodbDemoDao {

    void insert(DemoEntity demoEntity);

    void delete(String id);

    List<DemoEntity> list(String name,String type, Criteria criteria);

}
