package com.personal.cloud.demo.tool;

import com.personal.cloud.demo.support.RestResultDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class RestResultUtil {

    private static final Logger logger = LoggerFactory.getLogger(RestResultUtil.class);

    public static RestResultDto<?> handleException(Exception e, String message){
        return handleException(e,new RestResultDto<>(),message);
    }

    public static RestResultDto<?> handleException(Exception e,RestResultDto<?> result, String message){
        if(e instanceof IllegalArgumentException){
            message = e.getMessage();
        }
        message = StringUtils.isNotBlank(message) ? message : "失败";
        result.setResult(RestResultDto.RESULT_FAIL);
        result.setMsg(message);
        result.setException(e.getMessage());
        logger.error(message, e);
        return result;
    }
    public static RestResultDto<?> handleSuccess(){
        return handleSuccess(new RestResultDto<>(),null,"");
    }

    public static RestResultDto<?> handleSuccess(String message){
        return handleSuccess(new RestResultDto<>(),null,message);
    }
    public static <T> RestResultDto<T> handleSuccess(T data){
        return handleSuccess(new RestResultDto<T>(),data,"");
    }

    public static <T> RestResultDto<T> handleSuccess(T data,String message){
        return handleSuccess(new RestResultDto<T>(),data,message);
    }
    public static <T> RestResultDto<T> handleSuccess(RestResultDto<T> result,T data, String message){
        message = StringUtils.isNotBlank(message) ? message : "成功";
        result.setResult(RestResultDto.RESULT_SUCC);
        if(Objects.nonNull(data)){
            result.setData(data);
        }
        result.setMsg(message);
        return result;
    }
}
