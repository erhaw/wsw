package com.personal.cloud.demo.dao.impl;

import com.personal.cloud.demo.dao.IMongodbDemoDao;
import com.personal.cloud.demo.domain.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019-07-30.
 */
@Repository
public class MongodbDemoDaoImpl implements IMongodbDemoDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    public void insert(DemoEntity demoEntity) {
        mongoTemplate.save(demoEntity);
    }

    public void delete(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query,DemoEntity.class);
    }

    public List<DemoEntity> list(String name, String type, Criteria criteria) {
//        Query query = new Query(Criteria.where("name").is(name).and("type").is(type));
        Query query = new Query(criteria);
        List<DemoEntity> resultList = mongoTemplate.find(query,DemoEntity.class);
        return resultList;
    }
}
