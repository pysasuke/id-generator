package com.py.common;

/**
 * Created by pysasuke on 2016/9/7.
 *
 * 通用枚举类
 */

public class CommonEnum {

    /**
     * 返回状态
     */
    public static enum RESPONSE_STATUS {
        FAILED("0", "失败"), // 失败
        SUCCEED("1", "成功"); // 成功

        private String value;
        private String desc;

        private RESPONSE_STATUS(String iValue, String idesc) {
            this.value = iValue;
            this.desc = idesc;
        }

        public String getValue() {
            return this.value;
        }

        public String getDesc() {
            return this.desc;
        }
    }


}
