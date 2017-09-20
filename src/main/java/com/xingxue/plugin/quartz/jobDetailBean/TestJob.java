package com.xingxue.plugin.quartz.jobDetailBean;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/20.
 */
public class TestJob extends QuartzJobBean{


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        System.out.println(new Date().getTime());

    }
}
