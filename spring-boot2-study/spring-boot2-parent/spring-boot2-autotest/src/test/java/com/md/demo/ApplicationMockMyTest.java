package com.md.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc//注解是自动加载MockMvc
@WebAppConfiguration//注解是为了声明加载的ApplicationContext是WebApplicationContext,指定的Web默认资源位置是 src/main/webapp
public class ApplicationMockMyTest {
    private static Logger logger = LoggerFactory.getLogger(ApplicationMockMyTest.class);

    @Autowired
    //添加了@AutoConfigureMockMvc mockMvc才注入到容器中
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUpMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Before
    public void testBefore(){
        logger.info("测试前打印");
    }
    @After
    public void testAfter(){
        logger.info("测试后打印");
    }
    @Test
    public void ApiTest() throws Exception {
        String url = "/hello";
        String expectResult = "Hello，greetings from sprint-boot2-autotest";
        //要求接口状态正常且接口返回正常
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(expectResult)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        logger.info("/hello status {}",status);

        String contentAsString = mvcResult.getResponse().getContentAsString();
        logger.info("/hello result {}",contentAsString);

    }
}
