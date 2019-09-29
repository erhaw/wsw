package com.personal.cloud.controller.demo;

import com.personal.cloud.controller.BaseController;
import com.personal.cloud.demo.dao.DemoEntityDto;
import com.personal.cloud.demo.service.demo.IDemoCallableService;
import com.personal.cloud.demo.support.RestResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019-09-29.
 */
@Api(tags = "并发执行Demo",position = 1)
@CrossOrigin
@RestController
@RequestMapping(value = "/api/cp/demo/callable", method = {RequestMethod.GET, RequestMethod.POST})
public class DemoCallableController extends BaseController{

    @Autowired
    private IDemoCallableService demoCallableService;

    @ApiOperation("列表查询")
    @RequestMapping(value = "list")
    public RestResultDto<List<DemoEntityDto>> list(@ApiParam("名称") @RequestParam(required = false) String name,
                                                   @ApiParam("类型") @RequestParam(required = false) String type) {
        return handleSuccess(demoCallableService.list(name, type));
    }

}
