package com.xingxue.plugin.quartz.spring.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/21.
 */
public class HelloWorldJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("----hello world---" + new Date());
    }
}
