package com.personal.cloud.controller;

import com.personal.cloud.demo.support.RestResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2019-09-28.
 */
public class BaseController {

    public static final String BACK_DYNAMIC_SUFFIX = ".smvc";

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public RestResultDto<?> handleSuccess() {
        return RestResultDto.newSuccess();
    }

    public <T> RestResultDto<T> handleSuccess(T data) {
        return RestResultDto.newSuccess(data);
    }

    public <T> RestResultDto<T> handleSuccess(T data, String msg) {
        return RestResultDto.newSuccess(data, msg);
    }

    public RestResultDto<?> handleFail(String msg) {
        return RestResultDto.newFalid(msg, null);
    }

    public <T> RestResultDto<T> handleFail(String msg, Exception e) {
        if (e == null) {
            logger.error(msg);
        } else {
            logger.error(msg, e);
        }
        return RestResultDto.newFalid(msg, e == null ? null : e.getMessage());
    }

}
