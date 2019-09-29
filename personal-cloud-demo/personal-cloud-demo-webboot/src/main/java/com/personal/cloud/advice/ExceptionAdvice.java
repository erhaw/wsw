package com.personal.cloud.advice;

import com.personal.cloud.demo.support.RestResultDto;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.personal.cloud.demo.tool.RestResultUtil.handleException;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RestResultDto<?> handleHttpJson(Exception e){
        return handleException(e,"json数据格式不正确,无法解析");
    }

    @ExceptionHandler(IllegalStateException.class)
    public RestResultDto<?> handleAssertException(Exception e){
        return handleException(e,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public RestResultDto<?> handleCommonException(Exception e){
        return handleException(e,"操作失败");
    }



}
