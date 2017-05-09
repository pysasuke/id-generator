package com.py.web;

import com.py.common.RestResult;
import com.py.service.GenneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by pysasuke on 2017/4/21.
 */
@RestController
public class StringRedisController {

    protected static Logger logger = LoggerFactory.getLogger(StringRedisController.class);

    @Resource
    GenneratorService genneratorService;

    @RequestMapping("getSection")
    public RestResult getSection(String serviceId, int size) {
        logger.debug("getSection:serviceId={},size={}", serviceId, size);

        return genneratorService.getSection(serviceId, size);
    }
}