package com.personal.cloud.demo.service.demo;

import com.personal.cloud.demo.dao.DemoEntityDto;

import java.util.List;

/**
 * Created by Administrator on 2019-09-29.
 */
public interface IDemoCallableService {

    List<DemoEntityDto> list(String name, String type);
}
