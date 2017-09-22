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
        ossUtil.uploadStr("Hello","test.txt");
    }

    @Test
    public void uploadBytes() throws Exception {
    }

    @Test
    public void uploadFile() throws Exception {
    }

    @Test
    public void createDir() throws Exception {
    }

    @Test
    public void download() throws Exception {
    }

    @Test
    public void createUrl() throws Exception {
    }

}