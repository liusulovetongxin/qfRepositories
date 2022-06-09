package com.qf;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @version V1.0
 * @Project logback
 * @Package com.qf
 * @Description:
 * @Date 2022/5/25 10:55
 */

public class TestLog {

    Logger logger = LoggerFactory.getLogger(TestLog.class);
    @Test
    public void test1(){

        logger.debug("这是debug");
        logger.debug("这是{},原因是{}","参数1","参数2");
        logger.info("这是info");
        logger.error("这是error");
        logger.trace("这是trace");
        logger.warn("这是warning");
    }
}
