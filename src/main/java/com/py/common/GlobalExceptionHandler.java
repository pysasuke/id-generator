package com.py.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pysasuke on 2017/5/9.
 * <p>
 * 全局异常处理
 */
@ControllerAdvice
//如果返回的为json数据或其它对象，添加该注解
@ResponseBody
public class GlobalExceptionHandler {
    //添加全局异常处理流程，根据需要设置需要处理的异常，本文以ServiceException(自定义异常)为例
    @ExceptionHandler(value = ServiceException.class)
    public RestResult RuntimeExceptionHandler(
            ServiceException exception) throws Exception {

        RestResult baseResult = new RestResult(exception.getCode().getValue(), exception.getMessage());
        return baseResult;
    }
}
