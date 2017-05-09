package com.py.factory;

import com.py.common.CommonEnum;
import com.py.common.ServiceException;
import com.py.domain.FirstServiceModel;
import com.py.domain.SecondServiceModel;
import com.py.domain.ServiceModel;

/**
 * Created by pysasuke on 2017/5/8.
 * <p>
 * ServiceModel工厂
 */
public class ServiceModelFactory {
    //服务号
    public final static String First = "01";
    public final static String Second = "02";

    public static ServiceModel getInstanse(String code) {
        ServiceModel serviceModel = null;
        switch (code) {
            case First: {
                serviceModel = new FirstServiceModel();
                break;
            }
            case Second: {
                serviceModel = new SecondServiceModel();
                break;
            }
            default:
                throw new ServiceException(CommonEnum.RESPONSE_STATUS.FAILED, "未知服务");
        }
        return serviceModel;
    }
}
