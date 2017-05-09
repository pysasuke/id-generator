package com.py.common;

/**
 * Created by pysasuke on 2017/5/9.
 * <p>
 * 统一返回对象
 */
public class RestResult {

    private String status; //返回状态  1:成功 ，0:失败
    private String msg; //返回信息
    private Object data;//返回数据

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getdata() {
        return data;
    }

    public void setdata(Object data) {
        this.data = data;
    }

    public RestResult() {
        this.status = CommonEnum.RESPONSE_STATUS.SUCCEED.getValue();
        this.msg = CommonEnum.RESPONSE_STATUS.SUCCEED.name();
    }

    public RestResult(Object data) {
        this.status = CommonEnum.RESPONSE_STATUS.SUCCEED.getValue();
        this.msg = CommonEnum.RESPONSE_STATUS.SUCCEED.name();
        this.data = data == null ? "" : data;

    }

    public RestResult(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public RestResult(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data == null ? "" : data;
    }

}
