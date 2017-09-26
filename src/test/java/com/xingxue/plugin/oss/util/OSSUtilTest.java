package com.xingxue.plugin.oss.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by 何冠雄 on 2017/9/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:oss/spring/spring-oss.xml")
public class OSSUtilTest {

    @Autowired
    private OSSUtil ossUtil;

    @Test
    public void uploadStr() throws Exception {
        ossUtil.uploadStr("Hello","deal1/test.txt");
    }

    @Test
    public void uploadBytes() throws Exception {
        ossUtil.uploadBytes("Hello".getBytes(),"deal1/bytes.txt");
    }

    @Test
    public void uploadFile() throws Exception {
        ossUtil.uploadFile("src/main/resources/oss/testFile/钢铁侠.png","deal1/test.png");
    }

    @Test
    public void createDir() throws Exception {
        ossUtil.createDir("deal1/");
    }

    @Test
    public void download() throws Exception {
        ossUtil.download();
    }

    @Test
    public void createUrl() throws Exception {
        ossUtil.createUrl("deal1/test.png");
    }

}