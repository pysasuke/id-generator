package com.py.common;


/**
 * Created by pysasuke on 2016/9/7.
 * <p>
 * 自定义异常类
 */
public class ServiceException extends RuntimeException {

    CommonEnum.RESPONSE_STATUS code;

    public ServiceException(CommonEnum.RESPONSE_STATUS code) {
        super();
        this.code = code;
    }

    public ServiceException(CommonEnum.RESPONSE_STATUS code, String message) {
        super(message);
        this.code = code;
    }

    public CommonEnum.RESPONSE_STATUS getCode() {
        return this.code;
    }
}
