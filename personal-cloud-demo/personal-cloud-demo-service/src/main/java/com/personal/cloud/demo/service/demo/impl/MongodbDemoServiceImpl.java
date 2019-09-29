package com.personal.cloud.demo.service.demo.impl;

import com.google.common.collect.Lists;
import com.personal.cloud.demo.dao.DemoEntityDto;
import com.personal.cloud.demo.dao.IMongodbDemoDao;
import com.personal.cloud.demo.domain.DemoEntity;
import com.personal.cloud.demo.service.demo.IMongodbDemoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2019-07-30.
 */
@Service("mongodbDemoService")
@Transactional
public class MongodbDemoServiceImpl implements IMongodbDemoService {

    @Autowired
    private IMongodbDemoDao mongodbDemoDao;


    public DemoEntity save(DemoEntity demoEntity) {
        if(demoEntity == null){
            demoEntity = new DemoEntity();
            demoEntity.setCode("DEMO0001");
            demoEntity.setName("测试");
            demoEntity.setDescription("demo学习");
            demoEntity.setNum(10);
            demoEntity.setOperateDate(new Date());
        }
        mongodbDemoDao.insert(demoEntity);
        return demoEntity;
    }

    public void delete(String id) {
        mongodbDemoDao.delete(id);
    }

    public List<DemoEntityDto> list(String name, String type) {
        Criteria criteria = new Criteria();
        if(!StringUtils.isEmpty(name)){
            Pattern pattern = Pattern.compile("^.*" + Pattern.quote(name) + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("name").regex(pattern);
        }
        if(!StringUtils.isEmpty(type)){
            Pattern pattern = Pattern.compile("^.*" + Pattern.quote(type) + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("type").regex(pattern);
        }
        Assert.isTrue(false,"查询失败！");
        List<DemoEntity> dataList = mongodbDemoDao.list(name,type,criteria);
        return mode2Dto(dataList);
    }

    private List<DemoEntityDto> mode2Dto(List<DemoEntity> list){
        List<DemoEntityDto> dtoList = Lists.newArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return dtoList;
        }
        list.forEach(item ->{
            DemoEntityDto dto = new DemoEntityDto();
            BeanUtils.copyProperties(item,dto);
            dtoList.add(dto);
        });
        return dtoList;
    }
}
