package com.md.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 简单的Java方法单元测试
 * @author zrh
 */

@RunWith(SpringRunner.class)//这个是注解的作用是更改测试运行器
@SpringBootTest(classes = {ApplicationJavaMyTest.class}) //webEnvironment 的作用是为了配置测试容器的环境，classes 是为了将某些类加载到测试容器中
public class ApplicationJavaMyTest {

    private static Logger logger = LoggerFactory.getLogger(ApplicationJavaMyTest.class);

    @Test
    public void test01(){
        logger.info("test 01");
    }

    @Test
    public void test02(){
        logger.info("test 02");
    }
    @Before//在本测试类，任意测试方法之前执行
    public void before01(){
        logger.info("before 01");
    }

    @After//在本测试类，任意测试方法之后执行
    public void after01(){
        logger.info("after 01");
    }
}
