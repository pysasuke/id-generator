package com.py.domain;

/**
 * Created by pysasuke on 2017/5/7.
 */
public class FirstServiceModel extends ServiceModel {

    private final String code = "01";//服务号
    private final int size = 20;//生成的id总位数

    public String getCode() {
        return code;
    }

    public int getSize() {
        return size;
    }

    public String getFormat() {
        return "%0" + String.valueOf(size - 10) + "d";
    }
}
