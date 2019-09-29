package com.personal.cloud.controller.demo;

import com.personal.cloud.controller.BaseController;
import com.personal.cloud.demo.dao.DemoEntityDto;
import com.personal.cloud.demo.domain.DemoEntity;
import com.personal.cloud.demo.service.demo.IMongodbDemoService;
import com.personal.cloud.demo.support.RestResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019-07-30.
 */
@Api(tags = "Demo接口")
@CrossOrigin
@RestController
@RequestMapping(value = "/api/cp/demo", method = {RequestMethod.GET, RequestMethod.POST})
public class DemoController extends BaseController {

    @Autowired
    private IMongodbDemoService mongodbDemoService;

    @ApiOperation(value = "保存Demo", notes = "")
    @PostMapping(value = "save")
    public DemoEntity save(@RequestBody DemoEntity demoEntity){
        return mongodbDemoService.save(demoEntity);
    }

    @ApiOperation(value = "删除数据")
    @GetMapping(value = "delete")
    public void delete(@ApiParam(value = "记录ID")@RequestParam String id){
        mongodbDemoService.delete(id);
    }

    @ApiOperation("列表查询")
    @RequestMapping(value = "list")
    public RestResultDto<List<DemoEntityDto>> list(@ApiParam("名称") @RequestParam(required = false) String name,
                                                   @ApiParam("类型") @RequestParam(required = false) String type) {
        return handleSuccess(mongodbDemoService.list(name, type));
    }

}
