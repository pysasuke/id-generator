package com.py.service;

import com.py.common.CommonEnum;
import com.py.common.RestResult;
import com.py.common.ServiceException;
import com.py.constans.Constants;
import com.py.domain.Section;
import com.py.domain.ServiceModel;
import com.py.factory.ServiceModelFactory;
import com.py.util.TimeTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pysasuke on 2017/5/5.
 */
@Service
public class GenneratorService {
    protected static Logger logger = LoggerFactory.getLogger(GenneratorService.class);

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valOpsStr;

    public RestResult getSection(String serviceId, int num) {
        ServiceModel serviceModel = null;
        try {
            serviceModel = ServiceModelFactory.getInstanse(serviceId);
        } catch (ServiceException e) {
            logger.debug("未知服务");
            throw new ServiceException(e.getCode(), e.getMessage());
        }

        String key = serviceModel.getCode();
        int size = serviceModel.getSize();
        String format = serviceModel.getFormat();

        String prefix;
        long start;
        long end;
        String value = valOpsStr.get(key);
        if (null == value) {
            //服务号2位 + 时间戳8位 + 不定位
            String value2 = serviceId + TimeTools.getCodingDate() + String.format(format, 0);//用0补够6位
            valOpsStr.set(key, value2);
            value = valOpsStr.get(key);
        }
        //前缀替换(时间戳需要改变)
        prefix = serviceId + TimeTools.getCodingDate();
        start = Long.parseLong(value.substring(Constants.GUDINGWEISHU_Service, size)) + 1;
        end = start + num - 1;

        valOpsStr.set(key, prefix + String.format(format, end));
        Section section = new Section(prefix + String.format(format, start), prefix + String.format(format, end));
        logger.info("获取成功，区间为：[" + start + "," + end + "]");
        return new RestResult(CommonEnum.RESPONSE_STATUS.SUCCEED.getValue(), CommonEnum.RESPONSE_STATUS.SUCCEED.name(), section);
    }
}
