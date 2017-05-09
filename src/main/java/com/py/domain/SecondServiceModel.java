package com.py.domain;

/**
 * Created by pysasuke on 2017/5/7.
 */
public class SecondServiceModel extends ServiceModel {

    private final String code = "02";
    private final int size = 32;

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
